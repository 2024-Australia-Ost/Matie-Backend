package com.ost.matie.repository.favorite_product;

import com.ost.matie.domain.favorite_product.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Long>, FavoriteProductRepositoryCustom {
}
