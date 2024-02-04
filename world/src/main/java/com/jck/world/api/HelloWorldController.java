package com.jck.world.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}