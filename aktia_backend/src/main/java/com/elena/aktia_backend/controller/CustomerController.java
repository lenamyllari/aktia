package com.elena.aktia_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/sayhello")
    public String sayHelloWorld(){
        return "Hello World!";
    }

}