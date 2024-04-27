package com.assesment.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private long id;
    private String code;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private String category;
    private String image;
}
