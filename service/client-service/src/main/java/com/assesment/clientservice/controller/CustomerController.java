package com.assesment.clientservice.controller;


import com.assesment.clientservice.service.CustomerService;
import com.assesment.clientservice.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService clientService;


    @GetMapping("/getallcustomer")
    public ResponseEntity<List<CustomerDTO>> getall(){
        return ResponseEntity.ok(clientService.getall());
    }

    @GetMapping("/getcustomerbyuserid/{id}")
    public ResponseEntity<CustomerDTO> getbyuserid(@PathVariable long id){
        return ResponseEntity.ok(clientService.getByUserId(id));
    }
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDto){
        return ResponseEntity.ok(clientService.create(customerDto));
    }

}
