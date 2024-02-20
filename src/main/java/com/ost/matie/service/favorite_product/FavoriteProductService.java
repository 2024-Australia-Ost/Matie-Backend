package com.ost.matie.service.favorite_product;

import com.ost.matie.domain.favorite_product.FavoriteProduct;
import com.ost.matie.dto.favorite_product.AddFavoriteProductRequest;
import com.ost.matie.dto.favorite_product.UpdateFavoriteProductRequest;
import com.ost.matie.exception.ProductNotFoundException;
import com.ost.matie.repository.favorite_product.FavoriteProductRepository;
import com.ost.matie.repository.product.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FavoriteProductService {
    private final FavoriteProductRepository favoriteProductRepository;
    private final ProductRepository productRepository;

    public FavoriteProduct save(AddFavoriteProductRequest request) {
        return favoriteProductRepository.save(request.toEntity());
    }

    public FavoriteProduct findByUserId(Long userId) {
        return favoriteProductRepository.findByUserId(userId);
    }

    @Transactional
    public FavoriteProduct update(Long userId, UpdateFavoriteProductRequest request) {
        checkProductId(request.getProduct());
        FavoriteProduct favoriteProduct = favoriteProductRepository.findByUserId(userId);
        favoriteProduct.update(request.getProduct());
        return favoriteProduct;
    }

    private void checkProductId(List<Long> products) {
        for(Long productId : products)
            if(!productRepository.existsById(productId)) throw ProductNotFoundException.EXCEPTION;
    }
}
