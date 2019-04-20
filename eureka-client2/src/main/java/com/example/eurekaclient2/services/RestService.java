package com.example.eurekaclient2.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class RestService {

    public ResponseEntity<String> sayHy(){
        return new ResponseEntity<>("Hy by Client2", HttpStatus.OK);
    }


}
