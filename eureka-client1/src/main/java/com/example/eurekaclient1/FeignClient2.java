package com.example.eurekaclient1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CLIENT2")
public interface FeignClient2 {

    @GetMapping("/api")
    String sayHyByClient2();
}
