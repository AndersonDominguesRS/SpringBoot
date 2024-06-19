package com.example.assesment0624.controller;

import com.example.assesment0624.model.Funcionario;
import com.example.assesment0624.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioService.buscarFuncionarios();
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        funcionarioService.excluir(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long
                                             id, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizar(id, funcionario);
    }
}
