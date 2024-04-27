package com.assesment.productservice.controller;


import com.assesment.productservice.dto.ProductDTO;
import com.assesment.productservice.dto.ResponseDTO;
import com.assesment.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/frontend/src/assets/img/product";

@Autowired
private ProductService productService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO<String>> uploadFile(
            @RequestParam("image") MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return ResponseEntity.ok(new ResponseDTO<>(false,"File Upload Failed",null));
        }
        String imageName = System.currentTimeMillis() + ".jpg";
        try {
            // Save the file
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, imageName);
            fileNames.append(imageName);
            Files.write(fileNameAndPath, image.getBytes());
            return ResponseEntity.ok(new ResponseDTO<>(true,"File Upload Successfull",imageName));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDTO<>(false,"File Upload Failed",imageName));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Read Operation
    @GetMapping
    public ResponseEntity<ProductDTO> getProductById(@RequestParam("id") long id) {
        ProductDTO productDto = productService.getProductById(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getbyids")
    public ResponseEntity<List<ProductDTO>> getProductsByIds(@RequestBody List<Long> ids ) {
        List<ProductDTO> productDtos = productService.getProductsByIds(ids);
        if (productDtos.isEmpty()) {
            return ResponseEntity.ok(productDtos);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> Product = productService.getAllProducts();
        if (Product != null) {
            return new ResponseEntity<>(Product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Operation
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO ProductDto) {
        ProductDTO updatedProduct = productService.updateProduct(ProductDto);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
