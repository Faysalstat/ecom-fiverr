package com.assesment.orderservice.serviceImp;

import com.assesment.orderservice.client.ProductFeignClient;
import com.assesment.orderservice.dto.CartItemDTO;
import com.assesment.orderservice.dto.ProductDTO;
import com.assesment.orderservice.entity.CartItem;
import com.assesment.orderservice.mapper.ProductMapper;
import com.assesment.orderservice.repository.CartRepository;
import com.assesment.orderservice.repository.ProductRepository;
import com.assesment.orderservice.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductFeignClient productFeignClient;



    @Override
    public List<ProductDTO> getallByUserId(long userId) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<CartItem> cartItemList = cartRepository.findAllByUserId(userId);
        if(!cartItemList.isEmpty()){
            for(CartItem cartItem:cartItemList){
                productDTOList.add(productMapper.toDto(productRepository.findById(cartItem.getProductId()).orElseThrow()));
            }
        }
        return productDTOList;
    }

    @Override
    public CartItem create(CartItemDTO dto) {
        CartItem model = new CartItem(dto.getUserId(),dto.getProductId());
        return cartRepository.save(model);
    }

    @Override
    public CartItemDTO delete(CartItem cartItem) {
        return null;
    }
}
