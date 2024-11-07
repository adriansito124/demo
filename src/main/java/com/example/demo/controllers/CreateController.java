package com.example.demo.controllers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserData;
import com.example.demo.impl.BcryptPasswordEncoderService;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PassService;

@RestController
@RequestMapping("/user") // user -> 8 // create -> 6
public class CreateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PassService service;

    @Autowired
    BcryptPasswordEncoderService criptar;

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserData data)
    {
        String username = data.username();
        String password = data.password();
        String email = data.email();

        String sinal = service.verify(password);

        if (password.length() < 4 || username.length() < 4 || email.length() < 4) {
            return ResponseEntity.ok("Todos os campos devem possuir ao menos 4 caracteres!");
        }

        if (!sinal.equals("ok")) {
            return ResponseEntity.ok(sinal);
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return ResponseEntity.ok("A senha deve conter pelo menos uma letra maiúscula!");
        }

        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return ResponseEntity.ok("A senha deve conter pelo menos um numero!");
        }

        if (!Pattern.compile(EMAIL_PATTERN).matcher(email).matches()) {
            return ResponseEntity.ok("O e-mail fornecido não tem um formato válido!");
        }

        if (userRepository.existsByUsername(username)) {
            return ResponseEntity.ok("Nome de usuário já está em uso!");
        }

        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.ok("Email já está em uso!");
        }

        String cripto = criptar.encode(password);

        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(cripto);
        user.setEmail(email);

        userRepository.save(user);

        return ResponseEntity.ok("Conta criada com sucesso!");
    }

}
