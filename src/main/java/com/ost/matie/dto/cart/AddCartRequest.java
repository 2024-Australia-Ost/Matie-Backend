package com.ost.matie.dto.cart;

import com.ost.matie.domain.cart.Cart;
import com.ost.matie.domain.product.Product;
import com.ost.matie.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddCartRequest {
    private Long count;
    private Product product;
    private Users user;

    public Cart toEntity() {
        return Cart.builder()
                .count(count)
                .product(product)
                .user(user)
                .build();
    }
}
