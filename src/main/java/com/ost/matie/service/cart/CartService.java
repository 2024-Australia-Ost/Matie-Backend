package com.ost.matie.service.cart;

import com.ost.matie.domain.cart.Cart;
import com.ost.matie.domain.comment.Comment;
import com.ost.matie.dto.cart.AddCartRequest;
import com.ost.matie.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    public Cart save(AddCartRequest request) {
        return cartRepository.save(request.toEntity());
    }

}
