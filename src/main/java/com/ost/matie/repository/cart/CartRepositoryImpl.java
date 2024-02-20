package com.ost.matie.repository.cart;

import com.ost.matie.domain.cart.Cart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.cart.QCart.cart;

@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Cart> findByUserId(Long userId) {
        return queryFactory
                .selectFrom(cart)
                .where(cart.user.id.eq(userId))
                .fetch();
    }
}
