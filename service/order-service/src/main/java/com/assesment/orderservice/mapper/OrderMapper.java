package com.assesment.orderservice.mapper;

import com.assesment.orderservice.dto.OrderDetailsDTO;
import com.assesment.orderservice.dto.OrderItemDTO;
import com.assesment.orderservice.dto.ProductDTO;
import com.assesment.orderservice.entity.OrderDetails;
import com.assesment.orderservice.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDetails toOrderEntity(OrderDetailsDTO dto){
        if (dto == null) {
            return null;
        }

        OrderDetails entity = new OrderDetails();
        entity.setUserId(dto.getUserId());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setTotalCost(dto.getTotalCost());
        return entity;
    }

    public OrderDetailsDTO toOrderDto(OrderDetails entity){
        if (entity == null) {
            return null;
        }

        OrderDetailsDTO dto = new OrderDetailsDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setTotalCost(entity.getTotalCost());
        return dto;
    }


    public OrderItem toOrderItemEntity(OrderItemDTO dto){
        if (dto == null) {
            return null;
        }

        OrderItem entity = new OrderItem();
//        entity.setId(d.getId());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setProductId(dto.getProductDTO().getId());
        return entity;
    }

    public OrderItemDTO toOrderItemDto(OrderItem entity){
        if (entity == null) {
            return null;
        }
        OrderItemDTO dto = new OrderItemDTO();
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setTotalPrice(entity.getTotalPrice());
        return dto;
    }

}
