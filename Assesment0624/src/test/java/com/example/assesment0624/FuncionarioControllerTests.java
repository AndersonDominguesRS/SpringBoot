package com.example.assesment0624;

import com.example.assesment0624.controller.FuncionarioController;
import com.example.assesment0624.model.Funcionario;
import com.example.assesment0624.service.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FuncionarioController.class)
@AutoConfigureMockMvc(addFilters = false)
public class FuncionarioControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionarioService funcionarioService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void novoFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        funcionario.setNome("Anderson");
        funcionario.setEmail("anderson@gmail.com");
        funcionario.setEndereco("Rua1");
        funcionario.setTelefone("51999299999");
        funcionario.setDataNascimento("11/02/1986");

        given(funcionarioService.salvar(any(Funcionario.class))).willReturn(funcionario);

        mockMvc.perform(post("/funcionario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Anderson"));
    }

    @Test
    public void removerFuncionario() throws Exception {
        mockMvc.perform(delete("/funcionario/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void listarFuncionarios() throws Exception {
        Funcionario funcionario2 = new Funcionario();
        funcionario2.setId(12);
        funcionario2.setNome("Roberto");
        funcionario2.setEmail("Roberto@gmail.com");
        funcionario2.setEndereco("Rua1");
        funcionario2.setTelefone("51999299999");
        funcionario2.setDataNascimento("11/02/1986");

        given(funcionarioService.buscarFuncionarios()).willReturn(Arrays.asList(funcionario2));

        mockMvc.perform(get("/funcionario"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].telefone").value("51999299999"));
    }

    @Test
    public void atualizarFuncionario() throws Exception {
        Funcionario funcionario3 = new Funcionario();
        funcionario3.setId(1);
        funcionario3.setNome("Carlos");
        funcionario3.setEmail("carlos@gmail.com");
        funcionario3.setEndereco("Rua1");
        funcionario3.setTelefone("51999299999");
        funcionario3.setDataNascimento("11/02/1986");

        given(funcionarioService.atualizar(anyLong(), any(Funcionario.class))).willReturn(funcionario3);

        mockMvc.perform(put("/funcionario/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario3)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Carlos"));

    }

}
