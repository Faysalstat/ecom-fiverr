package com.assesment.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartItemDTO {

    private long id;
    private long productId;
    private long userId;

    public CartItemDTO(long productId, long userId) {
        this.productId = productId;
        this.userId = userId;
    }
}
