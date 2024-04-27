package com.assesment.productservice.mapper;


import com.assesment.productservice.dto.ProductDTO;
import com.assesment.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setCode(product.getCode());
        dto.setName(product.getName());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setImage(product.getImage());
        return dto;
    }

    public Product toCreateEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Product entity = new Product();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setImage(dto.getImage());
        return entity;
    }

    public Product toUpdateEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setImage(dto.getImage());
        return entity;
    }
}
