package com.assesment.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderItemDTO {
    private long id;
    private ProductDTO productDTO;
    private Integer quantity;
    private double price;
    private double totalPrice;
}
