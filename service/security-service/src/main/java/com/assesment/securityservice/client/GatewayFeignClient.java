package com.assesment.securityservice.client;

import com.assesment.securityservice.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "client-service")
public interface GatewayFeignClient {
    @PostMapping("/client/create")
    public CustomerDTO create(@RequestBody CustomerDTO userClientDTO);
}
