package com.ost.matie.dto.product;

import com.ost.matie.domain.product.Category;
import com.ost.matie.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Long point;
    private final Category category;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.point = product.getPoint();
        this.category = product.getCategory();
    }
}
