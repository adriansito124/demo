package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;



@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
