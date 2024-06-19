package com.example.assesment0624.service;

import com.example.assesment0624.model.Usuario;
import com.example.assesment0624.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> todos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscaPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(String id, Usuario usuarioUpdate) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setSenha(usuarioUpdate.getSenha());
            return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
            usuarioUpdate.setId(id);
            return usuarioRepository.save(usuarioUpdate);
        });
    }

}
