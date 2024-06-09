package com.example.springboot_tp3.service;

import com.example.springboot_tp3.model.Curso;
import com.example.springboot_tp3.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

    @Cacheable(value="cursos")
    public List<Curso> buscarCursosCahc() {
        return cursoRepository.findAll();
    }


    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Cacheable(value="cursos")
    public Optional<Curso> buscarCursoPorIdCach(Long id) {
        return cursoRepository.findById(id);
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso atualizar(Long id, Curso cursoUpdate) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNome(cursoUpdate.getNome());
            return cursoRepository.save(curso);
        }).orElseGet(() -> {
            cursoUpdate.setId(id);
            return cursoRepository.save(cursoUpdate);
        });
    }
}
