package com.example.springboot_tp3.service;

import com.example.springboot_tp3.model.Aluno;
import com.example.springboot_tp3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarAlunos() {
        return alunoRepository.findAll();
    }

    @Cacheable(value="alunos")
    public List<Aluno> buscarAlunoscach() {
        return alunoRepository.findAll();
    }


    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Cacheable(value="alunos")
    public Optional<Aluno> buscarAlunoPorIdcach(Long id) {
        return alunoRepository.findById(id);
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Long id, Aluno alunoUpdate) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoUpdate.getNome());
            return alunoRepository.save(aluno);
        }).orElseGet(() -> {
            alunoUpdate.setId(id);
            return alunoRepository.save(alunoUpdate);
        });
    }
}
