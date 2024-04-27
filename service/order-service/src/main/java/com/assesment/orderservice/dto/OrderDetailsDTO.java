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
public class OrderDetailsDTO {
    private long id;
    private double totalCost;
    private String orderStatus;
    private long userId;
    private List<OrderItemDTO> orderItemDTOS;
}
