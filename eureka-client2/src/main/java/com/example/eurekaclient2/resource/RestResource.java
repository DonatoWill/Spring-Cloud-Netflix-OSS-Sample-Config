package com.example.eurekaclient2.resource;

import com.example.eurekaclient2.services.RestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@RestController
@RequestMapping("/cadastro")
public class RestResource {

    @Autowired
    RestService restService;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHy(){
        return restService.sayHy();
    }

    @HystrixCommand(fallbackMethod = "getRegisterBackup")
    @GetMapping()
    public ResponseEntity<String> register(){
        return new ResponseEntity<>("Cadastro de usuário", HttpStatus.OK);
    }

    public ResponseEntity<String> getRegisterBackup(){
        return new ResponseEntity<>("Fallback de cadastro executado", HttpStatus.OK);
    }

    @HystrixCommand(fallbackMethod = "getTestBackup")
    @GetMapping("/client1")
    public ResponseEntity<String> testeCallClient1(){
        final String uri = "http://localhost:8085/login";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<String> getTestBackup(){
        return new ResponseEntity<>("Fallback Teste!!", HttpStatus.OK);
    }

}
