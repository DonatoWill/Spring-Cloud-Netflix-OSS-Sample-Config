package com.example.eurekaclient1.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("client2")
public interface FeignClient2 {

    @GetMapping("/cadastro/hi")
    String sayHyByClient2();
}
