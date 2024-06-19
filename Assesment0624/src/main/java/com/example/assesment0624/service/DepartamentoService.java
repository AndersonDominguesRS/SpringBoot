package com.example.assesment0624.service;

import com.example.assesment0624.model.Departamento;
import com.example.assesment0624.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> buscarDepartamentos() {
        return departamentoRepository.findAll();
    }


    public Optional<Departamento> buscarDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public void excluir(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Departamento atualizar(Long id, Departamento departamentoUpdate) {
        return departamentoRepository.findById(id).map(departamento -> {
            departamento.setNome(departamentoUpdate.getNome());
            return departamentoRepository.save(departamento);
        }).orElseGet(() -> {
            departamentoUpdate.setId(id);
            return departamentoRepository.save(departamentoUpdate);
        });
    }
}

