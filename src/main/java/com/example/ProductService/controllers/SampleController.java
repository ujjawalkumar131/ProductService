package com.example.ProductService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/default")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello everyone";
    }

    @GetMapping("/bye")
    public String sayBye()
    {
        return "bye everyone";
    }
}
