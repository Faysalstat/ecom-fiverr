package com.assesment.orderservice.client;

import com.assesment.orderservice.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "client-service")
public interface CustomerFeignClient {
    @GetMapping("/getallcustomer")
    ResponseEntity<List<CustomerDTO>> getall();

    @GetMapping("/getcustomerbyuserid/{id}")
    ResponseEntity<CustomerDTO> getbyuserid(@PathVariable long id);
    @PostMapping("/create")
    ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDto);
}
