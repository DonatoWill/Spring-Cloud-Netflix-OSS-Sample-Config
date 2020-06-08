package com.example.eurekaclient1.resource;

import com.example.eurekaclient1.services.RestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class RestResource {

    @Autowired
    RestService restService;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHy(){
        return restService.sayHy();
    }

    @HystrixCommand(fallbackMethod = "GetLoginBackup")
    @GetMapping()
    public ResponseEntity<String> login(){
        return restService.login();
    }

    //Need to have the same parameter of endpoint
    public ResponseEntity<String> GetLoginBackup(){
        return new ResponseEntity<>("Fallback operation called!", HttpStatus.OK);
    }

}