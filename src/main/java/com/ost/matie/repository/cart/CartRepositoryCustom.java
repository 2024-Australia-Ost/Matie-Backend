package com.ost.matie.repository.cart;

import com.ost.matie.domain.cart.Cart;

import java.util.List;

public interface CartRepositoryCustom {
    List<Cart> findByUserId(Long userId);
}
