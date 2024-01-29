package com.ost.matie.repository.cart;

import com.ost.matie.domain.cart.Cart;

public interface CartRepositoryCustom {
    Cart findByUserId(Long userId);
}
