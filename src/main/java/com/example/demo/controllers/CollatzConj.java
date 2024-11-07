package com.example.demo.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Collatz;


@RestController
@CrossOrigin(origins = {"http://localhost:5257"})
@RequestMapping("/collatz")
public class CollatzConj {

    @GetMapping
    public Collatz reverso(@RequestParam int step, @RequestParam int current) {

        int n = current;
        for (int i = 0; i < step; i++) {
            if (n % 2 ==0) {
                n = n/2;
            }
            else{
                n = 3*n+1;
            }
        }

        return new Collatz(n);
    }
    
}
