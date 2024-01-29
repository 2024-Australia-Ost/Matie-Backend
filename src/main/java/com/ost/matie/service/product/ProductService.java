package com.ost.matie.service.product;

import com.ost.matie.domain.product.Product;
import com.ost.matie.exception.NotFoundException;
import com.ost.matie.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("상품의 정보를 찾을 수 없습니다. (id : " + id + ")"));
    }

    public List<Product> findAllByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }
}
