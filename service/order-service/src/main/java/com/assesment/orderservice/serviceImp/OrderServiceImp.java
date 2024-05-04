package com.assesment.orderservice.serviceImp;

import com.assesment.orderservice.dto.OrderDetailsDTO;
import com.assesment.orderservice.dto.OrderItemDTO;
import com.assesment.orderservice.entity.OrderDetails;
import com.assesment.orderservice.entity.OrderItem;
import com.assesment.orderservice.mapper.OrderMapper;
import com.assesment.orderservice.mapper.ProductMapper;
import com.assesment.orderservice.repository.OrderDetailsRepository;
import com.assesment.orderservice.repository.OrderItemRepository;
import com.assesment.orderservice.repository.ProductRepository;
import com.assesment.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDetailsRepository orderRepo;

    @Autowired
    private OrderItemRepository itemRepo;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public OrderDetailsDTO create(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails newOrderDetail = orderRepo.save(orderMapper.toOrderEntity(orderDetailsDTO));
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for(OrderItemDTO orderItemDTO:orderDetailsDTO.getOrderItemDTOS()){
            OrderItem item = orderMapper.toOrderItemEntity(orderItemDTO);
            item.setOrderId(newOrderDetail.getId());
            OrderItem createdItem = itemRepo.save(item);
            orderItems.add(orderMapper.toOrderItemDto(createdItem));
        }
        OrderDetailsDTO newOrderDetailDto = orderMapper.toOrderDto(newOrderDetail);
        newOrderDetailDto.setOrderItemDTOS(orderItems);
        return newOrderDetailDto;
    }

    @Override
    public OrderDetailsDTO update(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetail = orderRepo.findById(orderDetailsDTO.getId()).orElseThrow();
        orderDetail.setOrderStatus(orderDetailsDTO.getOrderStatus());
        orderRepo.saveAndFlush(orderDetail);
        return orderMapper.toOrderDto(orderDetail);
    }

    @Override
    public List<OrderDetailsDTO> getAllPendingOrder() {

        return null;
    }

    @Override
    public List<OrderDetailsDTO> getAllOrderByUserId(long userId) {
        List<OrderDetailsDTO> orderDetailsDTOList = new ArrayList<>();
        List<OrderDetails> orderDetails = orderRepo.findAllByUserId(userId);

        if(!orderDetails.isEmpty()){
            for(OrderDetails order:orderDetails){
                OrderDetailsDTO dto = orderMapper.toOrderDto(order);
                List<OrderItem> items = itemRepo.findAllByOrderId(order.getId());
                List<OrderItemDTO> orderItemsDtolist = new ArrayList<>();
                for(OrderItem item:items){
                    OrderItemDTO singleItem = orderMapper.toOrderItemDto(item);
                    singleItem.setProductDTO(productMapper.toDto(productRepository.findById(item.getProductId()).orElseThrow()));
                    orderItemsDtolist.add(singleItem);
                }
                dto.setOrderItemDTOS(orderItemsDtolist);
                orderDetailsDTOList.add(dto);
            }
        }
        return orderDetailsDTOList;
    }

    @Override
    public List<OrderDetailsDTO> getAllOrderByStatus(String status) {
        List<OrderDetailsDTO> orderDetailsDTOList = new ArrayList<>();
        List<OrderDetails> orderDetails = orderRepo.findAllByOrderStatus(status);

        if(!orderDetails.isEmpty()){
            for(OrderDetails order:orderDetails){
                OrderDetailsDTO dto = orderMapper.toOrderDto(order);
                List<OrderItem> items = itemRepo.findAllByOrderId(order.getId());
                List<OrderItemDTO> orderItemsDtolist = new ArrayList<>();
                for(OrderItem item:items){
                    OrderItemDTO singleItem = orderMapper.toOrderItemDto(item);
                    singleItem.setProductDTO(productMapper.toDto(productRepository.findById(item.getProductId()).orElseThrow()));
                    orderItemsDtolist.add(singleItem);
                }
                dto.setOrderItemDTOS(orderItemsDtolist);
                orderDetailsDTOList.add(dto);
            }
        }
        return orderDetailsDTOList;
    }

    @Override
    public Double calculateProfit(Double costPrice, Double sellingPrice, int quantity) {
        if (costPrice < 0 || sellingPrice < 0 || quantity < 0) {
            throw new IllegalArgumentException("Cost price, selling price, and quantity must not be negative.");
        }
        return (sellingPrice - costPrice) * quantity;

    }

//    @Autowired
//    private ProductRepository productRepository;
}
