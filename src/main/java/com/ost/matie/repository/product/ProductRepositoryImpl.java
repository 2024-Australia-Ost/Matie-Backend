package com.ost.matie.repository.product;

import com.ost.matie.domain.product.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.product.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Product> findAllByCategoryId(Integer categoryId) {
        return queryFactory
                .selectFrom(product)
                .where(product.category.id.eq(categoryId))
                .fetch();
    }
}
