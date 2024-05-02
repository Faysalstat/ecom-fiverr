package com.assesment.productservice.serviceImp;


import com.assesment.productservice.dto.ProductDTO;
import com.assesment.productservice.entity.Product;
import com.assesment.productservice.mapper.ProductMapper;
import com.assesment.productservice.repository.ProductRepository;
import com.assesment.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toCreateEntity(productDTO);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if (!productList.isEmpty()) {
            return productList.stream().map(productMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            log.error("Product Not Found");
            return null;
        }
    }

    @Override
    public ProductDTO getProductById(long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return productMapper.toDto(product);
        } else {
            log.error("Product Not Found");
            return null;
        }
    }

    @Override
    public List<ProductDTO> getProductsByIds(List<Long> ids) {
        List<ProductDTO> productList = new ArrayList<>();
        if (!ids.isEmpty()) {
            for (Long id : ids) {
                productList.add(productMapper.toDto(productRepository.findById(id).orElseThrow()));
            }
        }
        return productList;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(productDTO.getId());
        if (productOptional.isPresent()) {
            Product product = productMapper.toUpdateEntity(productDTO);
            return productMapper.toDto(productRepository.saveAndFlush(product));
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        productRepository.deleteById(existingProduct.getId());
    }
}
