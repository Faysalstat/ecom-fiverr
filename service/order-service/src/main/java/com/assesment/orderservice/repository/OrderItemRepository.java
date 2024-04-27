package com.assesment.orderservice.repository;

import com.assesment.orderservice.entity.OrderItem;
import com.assesment.orderservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByOrderId(long orderId);
}
