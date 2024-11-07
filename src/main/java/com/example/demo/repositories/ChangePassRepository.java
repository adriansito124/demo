package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Passe;


@Repository
public interface ChangePassRepository extends JpaRepository<Passe, Long> {
    Passe findByUsername(String username);
}
