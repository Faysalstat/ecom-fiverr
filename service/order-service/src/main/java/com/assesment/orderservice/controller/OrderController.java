package com.assesment.orderservice.controller;


import com.assesment.orderservice.dto.CartItemDTO;
import com.assesment.orderservice.dto.OrderDetailsDTO;
import com.assesment.orderservice.dto.ProductDTO;
import com.assesment.orderservice.entity.CartItem;
import com.assesment.orderservice.service.CartService;
import com.assesment.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    // Create Operation
    @PostMapping
    public ResponseEntity<OrderDetailsDTO> createOrders(@RequestBody OrderDetailsDTO orders) {
        OrderDetailsDTO createdOrder = orderService.create(orders);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<OrderDetailsDTO> updateOrders(@RequestBody OrderDetailsDTO orders) {
        OrderDetailsDTO createdOrder = orderService.update(orders);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    @GetMapping("/getallbyuser")
    public ResponseEntity<List<OrderDetailsDTO>> getallByUser(@RequestParam("userId") long userId){
        return ResponseEntity.ok(orderService.getAllOrderByUserId(userId));
    }

    @GetMapping("/getallbystatus")
    public ResponseEntity<List<OrderDetailsDTO>> getAllByStatus(@RequestParam("status") String status){
        return ResponseEntity.ok(orderService.getAllOrderByStatus(status));
    }

    @GetMapping("/cart/getall")
    public ResponseEntity<List<ProductDTO>> getall(@RequestParam("userId") long userId){
        return ResponseEntity.ok(cartService.getallByUserId(userId));
    }
    @PostMapping("/cart/create")
    public ResponseEntity<CartItem> createOrders(@RequestBody CartItemDTO cartItemDTO) {
        CartItem createdCartItem = cartService.create(cartItemDTO);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @PostMapping("/cart/delete")
    public ResponseEntity<CartItem> delete(@RequestBody CartItem cartItem) {
        cartService.delete(cartItem);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

}
