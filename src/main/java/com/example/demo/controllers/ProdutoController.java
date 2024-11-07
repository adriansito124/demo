package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthData;
import com.example.demo.dto.LoginData;
import com.example.demo.dto.ProdutoData;
import com.example.demo.dto.Token;
import com.example.demo.model.Produtos;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.User2Repository;
import com.example.demo.services.JWTService;


@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    ProdutoRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTService<Token> jwtService;

    @PostMapping
    public ResponseEntity<?> newProduct(@RequestBody ProdutoData data) {

        String titulo = data.title();
        String valor = data.value();
        String token = data.token();

        //Usuario user = jwtService.validate(token);

        // if (user == null) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        // }

        // String email = user.getEmail();
        // if (email == null || !email.endsWith("@loja.com")) {
        //     return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido: email inválido");
        // }

        Produtos produto = new Produtos();
        produto.setTitulo(titulo);
        produto.setValor(valor);

        repo.save(produto);

        return ResponseEntity.status(HttpStatus.OK).body("Produto cadastrado com sucesso");
    }

}
