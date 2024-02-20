package com.ost.matie.controller.cart;

import com.ost.matie.dto.cart.AddCartRequest;
import com.ost.matie.dto.cart.CartResponse;
import com.ost.matie.dto.cart.UpdateCartRequest;
import com.ost.matie.service.cart.CreateCartService;
import com.ost.matie.service.cart.FindByUserIdCartService;
import com.ost.matie.service.cart.UpdateCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CreateCartService createCartService;
    private final FindByUserIdCartService findByUserIdCartService;
    private final UpdateCartService updateCartService;

    @PostMapping
    public void createCart(@Valid @RequestBody AddCartRequest request) {
        createCartService.execute(request);
    }

    @GetMapping("/{userId}")
    public List<CartResponse> findByUserIdCart(@PathVariable Long userId) {
        return findByUserIdCartService.execute(userId);
    }

    @PutMapping("/{id}")
    public void updateCart(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCartRequest request
    ) {
        updateCartService.execute(id, request);
    }
}
