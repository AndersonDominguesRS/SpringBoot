package com.example.veiculor2dbc.controller;

import com.example.veiculor2dbc.model.Veiculo;
import com.example.veiculor2dbc.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public Flux<Veiculo> getAllVeiculos() {
        return veiculoService.getVeiculos();
    }

    @GetMapping("/{id}")
    public Mono<Veiculo> getVeiculo(@PathVariable Long id) {
        return veiculoService.getVeiculoId(id);
    }

    @PostMapping
    public Mono<Veiculo> postVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.saveVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteVeiculo(@PathVariable Long id) {
        return veiculoService.deleteVeiculo(id);
    }

    @PutMapping("/{id}")
    public Mono<Void> atualizaVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {

        veiculo.setId(id);
        return veiculoService.saveVeiculo(veiculo).then();
    }

}
