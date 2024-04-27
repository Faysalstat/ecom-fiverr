package com.assesment.orderservice.service;

import com.assesment.orderservice.dto.CustomerDTO;
import com.assesment.orderservice.dto.OrderDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderDetailsDTO create(OrderDetailsDTO orderDetailsDTO);

    OrderDetailsDTO update(OrderDetailsDTO orderDetailsDTO);
    List<OrderDetailsDTO> getAllPendingOrder();

    List<OrderDetailsDTO> getAllOrderByUserId(long userId);

    List<OrderDetailsDTO> getAllOrderByStatus(String status);

//    OrderDetailsDTO getById


 }
