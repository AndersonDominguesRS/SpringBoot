package com.example.assesment0624.controller;

import com.example.assesment0624.model.Usuario;
import com.example.assesment0624.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/incluir")
    public Usuario salvaUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.todos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscaUsuario(@PathVariable String id) {
        return usuarioService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizaUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario);
    }



}

