package com.example.alunoreactive.model;

import com.example.alunoreactive.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Aluno {

    @Id
    private Integer id;
    private String nome;
}
