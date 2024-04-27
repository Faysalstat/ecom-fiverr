package com.assesment.clientservice.serviceImp;

import com.assesment.clientservice.repository.CustomerRepository;
import com.assesment.clientservice.service.CustomerService;
import com.assesment.clientservice.dto.CustomerDTO;
import com.assesment.clientservice.entity.Customer;
import com.assesment.clientservice.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ClientServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerMapper mapper;
    @Override
    public List<CustomerDTO> getall() {
        List<Customer> clientDetailsList = repository.findAll();
        List<CustomerDTO> customerDtoList = new ArrayList<>();
        for (Customer clientDetails : clientDetailsList) {
            customerDtoList.add(mapper.toCustomerDto(clientDetails));
        }

        return customerDtoList;
    }

    @Override
    public CustomerDTO getByUserId(Long id) {
        return mapper.toCustomerDto(repository.findByUserId(id).orElseThrow());
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDto) {
        Customer newClientDetails = mapper.toCustomerEntity(customerDto);
        return mapper.toCustomerDto(repository.save(newClientDetails));
    }


}
