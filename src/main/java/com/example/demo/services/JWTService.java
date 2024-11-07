package com.example.demo.services;

import com.example.demo.dto.Token;
import com.example.demo.model.Usuario;

public interface JWTService<T> {
    String get(T token);
    Token validate(String jwt);
}