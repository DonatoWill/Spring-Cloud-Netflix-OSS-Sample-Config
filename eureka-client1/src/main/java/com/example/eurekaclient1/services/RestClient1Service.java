package com.example.eurekaclient1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class RestClient1Service {

    @Autowired
    FeignClient2 feignClient2;

    @Autowired
    Environment environment;

    public ResponseEntity<String> sayHy(){
        return new ResponseEntity<>(feignClient2.sayHyByClient2() + " using client 1  from port: " + environment.getProperty("local.server.port") , HttpStatus.OK);
    }


}
