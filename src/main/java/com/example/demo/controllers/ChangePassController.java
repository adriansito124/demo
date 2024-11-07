package com.example.demo.controllers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChangePass;
import com.example.demo.dto.UserData;
import com.example.demo.model.Passe;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.ChangePassRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PassService;

@RestController
@RequestMapping("/changepassword")
public class ChangePassController {

    @Autowired
    PassService service;

    @Autowired
    private ChangePassRepository repo;

    @PatchMapping
    public ResponseEntity<String> register(@RequestBody ChangePass data)
    {
        String name = data.username();
        String old = data.password();
        String novo = data.newPassword();
        String repeat = data.repeatPassword();

        
        Passe user = repo.findByUsername(name);

        String sinal = service.verify(novo);

        if (user == null) {
            return ResponseEntity.ok("Usuario nao encontrado!");
        }

        if (!user.getPassword().equals(old)) {
            return ResponseEntity.ok("Senha antiga incorreta!");
        }

        if (!sinal.equals("ok")) {
            return ResponseEntity.ok(sinal);
        }

        if (!novo.equals(repeat)) {
            return ResponseEntity.ok("As senhas devem ser identicas!");
        }

        user.setPassword(novo);

        repo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("Senha alterada com sucesso!");

    }

}
