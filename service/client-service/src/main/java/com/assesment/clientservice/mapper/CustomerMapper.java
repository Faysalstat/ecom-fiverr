package com.assesment.clientservice.mapper;


import com.assesment.clientservice.dto.CustomerDTO;
import com.assesment.clientservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toCustomerDto(Customer clientDetails){
        if (clientDetails == null) {
            return null;
        }

        CustomerDTO dto = new CustomerDTO();
        dto.setId(clientDetails.getId());
        dto.setFirstName(clientDetails.getFirstName());
        dto.setLastName(clientDetails.getLastName());
        dto.setPhoneNumber(clientDetails.getPhoneNumber());
        dto.setEmail(clientDetails.getEmail());
        dto.setGender(clientDetails.getGender());
        dto.setAddress(clientDetails.getAddress());
        dto.setUserId(clientDetails.getUserId());

        return dto;
    }

    public Customer toCustomerEntity(CustomerDTO customerDto){
        if (customerDto == null) {
            return null;
        }

        Customer entity = new Customer();
        entity.setFirstName(customerDto.getFirstName());
        entity.setLastName(customerDto.getLastName());
        entity.setPhoneNumber(customerDto.getPhoneNumber());
        entity.setEmail(customerDto.getEmail());
        entity.setUserId(customerDto.getUserId());
        entity.setGender(customerDto.getGender());
        entity.setAddress(customerDto.getAddress());
        return entity;
    }


}
