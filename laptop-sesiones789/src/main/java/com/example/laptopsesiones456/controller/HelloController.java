package com.example.laptopsesiones456.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.message}")
    String message;
    @Value("${app.varexample}")
    String varexample;
    @GetMapping("/hello")//Vinculamos a una url
    public String saludo(){
        System.out.println(message);
        System.out.println(varexample);
        return "Estamos avanzando con Spring Boot!";
    }
}
