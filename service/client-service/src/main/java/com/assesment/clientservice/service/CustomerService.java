package com.assesment.clientservice.service;

import com.assesment.clientservice.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerDTO> getall();
    CustomerDTO getByUserId(Long id);
    CustomerDTO create(CustomerDTO customerDto);
}
