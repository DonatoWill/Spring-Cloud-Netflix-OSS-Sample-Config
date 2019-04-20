package com.example.eurekaclient2.resource;

import com.example.eurekaclient2.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestResource {

    @Autowired
    RestService restService;

    @GetMapping
    public ResponseEntity<String> sayHy(){
        return restService.sayHy();
    }


}
