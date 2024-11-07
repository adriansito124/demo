package com.example.demo.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ImaExp;


@RestController
@CrossOrigin(origins = {"http://localhost:5257"})
@RequestMapping("/imaexp")
public class ImaginaryExp {

    @GetMapping
    public ImaExp reverso(@RequestParam double A, @RequestParam double b) {

        double n1 = A * Math.cos(b);

        double n2 = A * Math.sin(b);

        return new ImaExp(n1, n2);
    }
    
}
