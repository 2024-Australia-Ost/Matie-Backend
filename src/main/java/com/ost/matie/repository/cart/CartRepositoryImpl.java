package com.ost.matie.repository.cart;

import com.ost.matie.domain.cart.Cart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ost.matie.domain.cart.QCart.cart;

@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Cart findByUserId(Long userId) {
        return queryFactory
                .selectFrom(cart)
                .where(cart.user.id.eq(userId))
                .fetchOne();
    }
}
