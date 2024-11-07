package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Palindromo;
import com.example.demo.services.ReverseService;


@RestController
@RequestMapping("/reverse")
public class Reverse {

    @Autowired
    ReverseService service;

    @GetMapping("/{word}")
    public Palindromo reverso(@PathVariable String word) {

        Boolean resultado = service.inverso(word);
        return new Palindromo(word, resultado);
    }
    
}
