package com.assesment.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)																					// value for id field in the
    private long id;

    @Column
    private long userId;

    @Column
    private long productId;

    public CartItem(long userId, long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
