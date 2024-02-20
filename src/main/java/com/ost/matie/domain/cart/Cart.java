package com.ost.matie.domain.cart;

import com.ost.matie.domain.product.Product;
import com.ost.matie.domain.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "count")
    private Long count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Cart(Long count, Product product, Users user) {
        this.count = count;
        this.product = product;
        this.user = user;
    }

    public void update(Long count, Product product) {
        this.count = count;
        this.product = product;
    }
}
