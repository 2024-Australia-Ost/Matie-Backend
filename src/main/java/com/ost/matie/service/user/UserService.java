package com.ost.matie.service.user;

import com.ost.matie.domain.user.Users;
import com.ost.matie.dto.user.AddUserRequest;
import com.ost.matie.dto.user.LoginUserRequest;
import com.ost.matie.dto.user.UpdateUserRequest;
import com.ost.matie.exception.DuplicateException;
import com.ost.matie.exception.NotFoundException;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public Users save(AddUserRequest request) {
        duplicateUserId(request.getUserId());
        duplicateEmail(request.getEmail());

        request.setPw(bCryptPasswordEncoder.encode(request.getPw()));

        return userRepository.save(request.toEntity());
    }

    public void duplicateEmail(String email) {
        if(userRepository.existsByEmail(email)) throw new DuplicateException("email", "Email already exists, use another email address or login");
    }

    public void duplicateUserId(String userId) {
        if(userRepository.existsByUserId(userId)) throw new DuplicateException("userId", "ID already exists, use another ID");
    }

    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. (id : " + id + ")"));
    }

    public Users login(LoginUserRequest request) {
        Users users = userRepository.findByUserIdOrEmail(request.getUserId(), request.getUserId());
        if(users == null || !bCryptPasswordEncoder.matches(request.getPw(), users.getPw())) throw new NotFoundException("Check your email/id or password");
        return users;
    }

    public void delete(Long id) {
        if(!userRepository.existsById(id)) throw new NotFoundException("사용자를 찾을 수 없습니다. (id : " + id + ")");
        userRepository.deleteById(id);
    }


    @Transactional
    public Users update(String email, UpdateUserRequest request) {
        Users users = userRepository.findByEmail(email);
        users.update(bCryptPasswordEncoder.encode(request.getPw()));
        return users;
    }
}
