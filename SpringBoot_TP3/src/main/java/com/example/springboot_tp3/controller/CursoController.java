package com.example.springboot_tp3.controller;

import com.example.springboot_tp3.model.Curso;
import com.example.springboot_tp3.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.buscarCursos();
    }

    @GetMapping("/cach")
    public String listarCach() {
        long start = System.currentTimeMillis();
        List<Curso> cursos = cursoService.buscarCursosCahc();
        long end = System.currentTimeMillis();
        long duration = end - start;
        return "Duração com cache: " + duration + " mms";
    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoService.salvar(curso);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id) {
         cursoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable long id, @RequestBody Curso curso) {
        return cursoService.atualizar(id, curso);
    }
}
