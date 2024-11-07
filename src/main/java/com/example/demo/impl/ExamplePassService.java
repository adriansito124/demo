package com.example.demo.impl;

import com.example.demo.services.PassService;
import com.example.demo.services.ReverseService;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;

public class ExamplePassService implements PassService{

    @Override
    public String verify(String senha) {

        if (senha.length() < 8) {
            return "A senha deve possuir ao menos 8 caracteres!";
        }

        if (!Pattern.compile("[a-z]").matcher(senha).find()) {
            return "A senha deve conter pelo menos uma letra minúscula!";
        }

        if (!Pattern.compile("[A-Z]").matcher(senha).find()) {
            return "A senha deve conter pelo menos uma letra maiúscula!";
        }

        if (!Pattern.compile("[0-9]").matcher(senha).find()) {
            return "A senha deve conter pelo menos um numero!";
        }

        return "ok";
    }
}

