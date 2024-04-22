package com.example.class_exercises.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome Spring Boot.!";
    }

    @GetMapping("/studentName")
    public String Student(@RequestParam("name") String studentName) {
        return "Welcome " + studentName + "!";
    }
}
