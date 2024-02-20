package com.ost.matie.service.user;

import com.ost.matie.domain.user.Users;
import com.ost.matie.dto.user.AddUserRequest;
import com.ost.matie.dto.user.LoginUserRequest;
import com.ost.matie.dto.user.UpdateUserRequest;
import com.ost.matie.exception.EmailDuplicateException;
import com.ost.matie.exception.UserIdDuplicateException;
import com.ost.matie.exception.UserIncorrectException;
import com.ost.matie.exception.UserNotFoundException;
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
        if(userRepository.existsByEmail(email)) throw EmailDuplicateException.EXCEPTION;
    }

    public void duplicateUserId(String userId) {
        if(userRepository.existsByUserId(userId)) throw UserIdDuplicateException.EXCEPTION;
    }

    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public Users login(LoginUserRequest request) {
        Users users = userRepository.findByUserIdOrEmail(request.getUserId(), request.getUserId());
        if(users == null || !bCryptPasswordEncoder.matches(request.getPw(), users.getPw())) throw UserIncorrectException.EXCEPTION;
        return users;
    }

    public void delete(Long id) {
        if(!userRepository.existsById(id)) throw UserNotFoundException.EXCEPTION;
        userRepository.deleteById(id);
    }


    @Transactional
    public Users update(String email, UpdateUserRequest request) {
        Users users = userRepository.findByEmail(email);
        users.update(bCryptPasswordEncoder.encode(request.getPw()));
        return users;
    }
}
