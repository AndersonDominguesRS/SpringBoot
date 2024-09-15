package com.example.alunoreactive.repository;

import com.example.alunoreactive.model.Aluno;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AlunoRepository extends R2dbcRepository<Aluno, Integer> {
}
