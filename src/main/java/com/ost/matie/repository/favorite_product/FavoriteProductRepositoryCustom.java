package com.ost.matie.repository.favorite_product;

import com.ost.matie.domain.favorite_product.FavoriteProduct;

public interface FavoriteProductRepositoryCustom {
    FavoriteProduct findByUserId(Long userId);
}
