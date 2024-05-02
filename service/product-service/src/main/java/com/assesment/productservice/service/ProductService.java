package com.assesment.productservice.service;


import com.assesment.productservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(long productId);

    List<ProductDTO> getProductsByIds(List<Long> ids);

    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(Long id);


}
