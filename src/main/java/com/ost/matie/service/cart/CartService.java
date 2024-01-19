package com.ost.matie.service.cart;

import com.ost.matie.domain.cart.Cart;
import com.ost.matie.dto.cart.AddCartRequest;
import com.ost.matie.dto.cart.UpdateCartRequest;
import com.ost.matie.exception.*;
import com.ost.matie.repository.CartRepository;
import com.ost.matie.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart save(AddCartRequest request) {
        return cartRepository.save(request.toEntity());
    }

    public Cart findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Transactional
    public Cart update(Long userId, UpdateCartRequest request) {
        Cart cart = cartRepository.findByUserId(userId);

        checkProductAndCount(request.getProducts(), request.getCount());

        cart.update(
                request.getCount(),
                request.getProducts()
        );

        return cart;
    }

    private void checkProductAndCount(List<Long> products, List<Long> counts) {
        for(Long productId : products)
            if(!productRepository.existsById(productId)) throw new NotFoundException("상품의 정보를 찾을 수 없습니다. (id : " + productId + ")");

        if(products.size() != counts.size()) throw new SizePreconditionFailException("상품과 갯수 리스트의 사이즈가 동일하지 않습니다.");
    }
}
