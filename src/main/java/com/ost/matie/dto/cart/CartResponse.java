package com.ost.matie.dto.cart;

import com.ost.matie.domain.cart.Cart;
import com.ost.matie.domain.product.Product;
import com.ost.matie.dto.user.UserResponse;
import lombok.Getter;

@Getter
public class CartResponse {
    private final Long id;
    private final Long count;
    private final Product product;
    private final UserResponse user;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.count = cart.getCount();
        this.product = cart.getProduct();
        this.user = new UserResponse(cart.getUser());
    }
}
