package com.example.springboot_tp3.repository;

import com.example.springboot_tp3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
