package com.ost.matie.service.cart;

import com.ost.matie.dto.cart.CartResponse;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.cart.CartRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByUserIdCartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<CartResponse> execute(Long userId) {
        if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;
        return cartRepository.findByUserId(userId)
                .stream()
                .map(CartResponse::new)
                .toList();
    }
}
