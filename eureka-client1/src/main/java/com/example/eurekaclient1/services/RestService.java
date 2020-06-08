package com.example.eurekaclient1.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    public ResponseEntity<String> sayHy(){
        return new ResponseEntity<>("Hy by Client2", HttpStatus.OK);
    }

    public ResponseEntity<String> login() {
        return new ResponseEntity<>("Fazer Login", HttpStatus.OK);
    }
}