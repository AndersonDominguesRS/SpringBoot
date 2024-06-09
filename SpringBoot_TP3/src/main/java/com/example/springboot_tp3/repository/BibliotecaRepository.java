package com.example.springboot_tp3.repository;

import com.example.springboot_tp3.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends MongoRepository<Biblioteca, String> {
}
