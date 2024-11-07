package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.repositories.CitiesRepository;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    CitiesRepository repo;

    // @GetMapping("/id/{id}")
    // public ResponseEntity<City> getById(@PathVariable Long id){
    //     var cidadi = repo.findById(id);

    //     if (!cidadi.isPresent()) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }

    //     return new ResponseEntity<>(cidadi.get(), HttpStatus.OK);
    // }

    @GetMapping("/{search}")
    public ResponseEntity<List<City>> getByName(@PathVariable String search) {
        var cidadela = repo.findByName(search);

        return new ResponseEntity<>(cidadela, HttpStatus.OK);
    }
}
