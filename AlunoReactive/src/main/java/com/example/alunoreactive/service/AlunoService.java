package com.example.alunoreactive.service;

import com.example.alunoreactive.model.Aluno;
import com.example.alunoreactive.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Flux<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public Mono<Aluno> getAlunoId(Integer id) {
        return alunoRepository.findById(id);
    }

    public Mono<Aluno> saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Mono<Void> deleteAluno(Integer id) {
        return alunoRepository.deleteById(id);
    }
}
