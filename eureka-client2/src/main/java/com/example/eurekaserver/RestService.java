package com.example.eurekaserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestService {

    public RestService() {
    }

    @GetMapping
    public ResponseEntity<String> sayHy(){
        return new ResponseEntity<>("Hy by Client2", HttpStatus.OK);
    }


}
