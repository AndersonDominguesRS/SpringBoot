package com.example.assesment0624.controller;

import com.example.assesment0624.model.Departamento;
import com.example.assesment0624.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> listar() {
        return departamentoService.buscarDepartamentos();
    }

    @PostMapping
    public Departamento cadastrar(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        departamentoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Departamento atualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.atualizar(id, departamento);
    }
}
