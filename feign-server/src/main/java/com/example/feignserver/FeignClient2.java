package com.example.feignserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("CLIENT2")
public interface FeignClient2 {

    @GetMapping("/api")
    String sayHyByClient2();
}
