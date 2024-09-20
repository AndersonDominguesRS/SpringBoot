package com.example.veiculor2dbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table("veiculo")
public class Veiculo {

    @Id
    private Long id;
    private String placa;
    private String modelo;
    private String cor;
}
