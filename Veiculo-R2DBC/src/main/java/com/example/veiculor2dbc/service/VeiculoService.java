package com.example.veiculor2dbc.service;

import com.example.veiculor2dbc.exception.ResourseNotFoundException;
import com.example.veiculor2dbc.model.Veiculo;
import com.example.veiculor2dbc.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Flux<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }

    public Mono<Veiculo> getVeiculoId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Mono<Veiculo> saveVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Mono<Void> deleteVeiculo(Long id) {
        return veiculoRepository.deleteById(id);
    }

    public Mono<Void> atualizarVeiculo(Veiculo veiculo) {

        return veiculoRepository.save(veiculo).then();
    }
}

