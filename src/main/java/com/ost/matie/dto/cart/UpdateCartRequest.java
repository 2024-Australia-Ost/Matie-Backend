package com.ost.matie.dto.cart;

import com.ost.matie.domain.product.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateCartRequest {
    @NotNull(message = "상품 갯수 리스트를 넣어주세요.")
    private Long count;

    @NotNull(message = "상품 리스트를 넣어주세요.")
    private Product product;
}
