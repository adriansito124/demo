package com.example.demo.impl;

import com.example.demo.services.ReverseService;

import java.util.ArrayList;

public class ExampleReverseService implements ReverseService{

    @Override
    public Boolean inverso(String word) {
        ArrayList<String> reverse = new ArrayList<>();
        ArrayList<String> normal = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            reverse.add(word.substring(word.length()-(i+1), word.length()-i));
            normal.add(word.substring(i, i+1));
        }
        String resultado  = reverse.toString();
        resultado = resultado.replaceAll(",", "");
        resultado = resultado.replaceAll(" ", "");
        if (reverse.equals(normal)) {
            return true;
        }
        return false;
    }
}

