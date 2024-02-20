package com.ost.matie.service.cart;

import com.ost.matie.dto.cart.AddCartRequest;
import com.ost.matie.repository.cart.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCartService {
    private final CartRepository cartRepository;

    @Transactional
    public void execute(AddCartRequest request) {
        cartRepository.save(request.toEntity());
    }
}
