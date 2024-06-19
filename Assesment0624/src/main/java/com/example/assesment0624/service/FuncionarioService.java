package com.example.assesment0624.service;

import com.example.assesment0624.model.Funcionario;
import com.example.assesment0624.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> buscarFuncionarios() {
        return funcionarioRepository.findAll();
    }


    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizar(Long id, Funcionario funcionarioUpdate) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioUpdate.getNome());
            return funcionarioRepository.save(funcionario);
        }).orElseGet(() -> {
            funcionarioUpdate.setId(id);
            return funcionarioRepository.save(funcionarioUpdate);
        });
    }
}

