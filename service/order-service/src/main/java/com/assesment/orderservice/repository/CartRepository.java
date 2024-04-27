package com.assesment.orderservice.repository;

import com.assesment.orderservice.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findAllByUserId(long userId);
}
