package com.ost.matie.service.cart;

import com.ost.matie.domain.cart.Cart;
import com.ost.matie.dto.cart.UpdateCartRequest;
import com.ost.matie.exception.CartNotFoundException;
import com.ost.matie.repository.cart.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCartService {
    private final CartRepository cartRepository;

    @Transactional
    public void execute(Long id, UpdateCartRequest request) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> CartNotFoundException.EXCEPTION);
        cart.update(request.getCount());
    }
}
