package com.example.springboot_tp3.controller;

import com.example.springboot_tp3.model.Biblioteca;
import com.example.springboot_tp3.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping
    public List<Biblioteca> listar() {
        return bibliotecaService.buscarBibliotecas();
    }

    @PostMapping
    public Biblioteca cadastrar(@RequestBody Biblioteca biblioteca) {
        return bibliotecaService.salvar(biblioteca);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        bibliotecaService.excluir(id);
    }

    @PutMapping("/{id}")
    public Biblioteca atualizar(@PathVariable String id, @RequestBody Biblioteca biblioteca) {
        return bibliotecaService.atualizar(id, biblioteca);
    }
}
