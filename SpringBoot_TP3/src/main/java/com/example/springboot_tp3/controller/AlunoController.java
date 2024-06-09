package com.example.springboot_tp3.controller;

import com.example.springboot_tp3.model.Aluno;
import com.example.springboot_tp3.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.buscarAlunos();
    }

    @GetMapping("/cach")
    public List<Aluno> listarCach() {
        return alunoService.buscarAlunoscach();
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id) {
        alunoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable long id, @RequestBody Aluno aluno) {
        return alunoService.atualizar(id, aluno);
    }
}

