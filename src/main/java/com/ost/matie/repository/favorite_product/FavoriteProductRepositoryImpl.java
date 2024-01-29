package com.ost.matie.repository.favorite_product;

import com.ost.matie.domain.favorite_product.FavoriteProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ost.matie.domain.favorite_product.QFavoriteProduct.favoriteProduct;

@Repository
@RequiredArgsConstructor
public class FavoriteProductRepositoryImpl implements FavoriteProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public FavoriteProduct findByUserId(Long userId) {
        return queryFactory
                .selectFrom(favoriteProduct)
                .where(favoriteProduct.user.id.eq(userId))
                .fetchOne();
    }
}
