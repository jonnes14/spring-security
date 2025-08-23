package com.jonnes.spring_security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("sample")
    public String sample(){
        return "sample";
    }
}
