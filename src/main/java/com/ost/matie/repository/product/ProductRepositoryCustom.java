package com.ost.matie.repository.product;

import com.ost.matie.domain.product.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAllByCategoryId(Integer categoryId);
}
