package com.example.springboot_tp3.service;

import com.example.springboot_tp3.model.Biblioteca;
import com.example.springboot_tp3.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Biblioteca salvar(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> buscarBibliotecas() {
        return bibliotecaRepository.findAll();
    }


    public Optional<Biblioteca> buscarBibliotecaPorId(String id) {
        return bibliotecaRepository.findById(id);
    }

    public void excluir(String id) {
        bibliotecaRepository.deleteById(id);
    }

    public Biblioteca atualizar(String id, Biblioteca bibliotecaUpdate) {
        return bibliotecaRepository.findById(id).map(biblioteca -> {
            biblioteca.setTitulo(bibliotecaUpdate.getTitulo());
            return bibliotecaRepository.save(biblioteca);
        }).orElseGet(() -> {
            bibliotecaUpdate.setId(id);
            return bibliotecaRepository.save(bibliotecaUpdate);
        });
    }
}
