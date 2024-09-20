package com.example.veiculor2dbc.repository;

import com.example.veiculor2dbc.model.Veiculo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface VeiculoRepository extends R2dbcRepository<Veiculo, Long> {
}
