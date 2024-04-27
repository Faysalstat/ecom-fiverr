package com.assesment.orderservice.repository;

import com.assesment.orderservice.entity.OrderDetails;
import com.assesment.orderservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    List<OrderDetails> findAllByUserId(long userId);
    List<OrderDetails> findAllByOrderStatus(String orderStatus);
}
