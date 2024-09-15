package com.example.alunoreactive.controller;

import com.example.alunoreactive.model.Aluno;
import com.example.alunoreactive.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public Flux<Aluno> getAllAlunos() {
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}")
    public Mono<Aluno> getAluno(@PathVariable int id) {
        return alunoService.getAlunoId(id);
    }

    @PostMapping
    public Mono<Aluno> postAluno(@RequestBody Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAluno(@PathVariable Integer id) {
       return alunoService.deleteAluno(id);
    }

}
