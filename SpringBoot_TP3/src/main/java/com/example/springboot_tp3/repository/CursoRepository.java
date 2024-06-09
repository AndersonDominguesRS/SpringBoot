package com.example.springboot_tp3.repository;

import com.example.springboot_tp3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
