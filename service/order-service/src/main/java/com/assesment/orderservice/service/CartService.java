package com.assesment.orderservice.service;

import com.assesment.orderservice.dto.CartItemDTO;
import com.assesment.orderservice.dto.ProductDTO;
import com.assesment.orderservice.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    List<ProductDTO> getallByUserId(long userId);
    CartItem create(CartItemDTO cartItem);
    CartItemDTO delete(CartItem cartItem);
}
