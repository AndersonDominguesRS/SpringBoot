package com.example.assesment0624;

import com.example.assesment0624.controller.DepartamentoController;
import com.example.assesment0624.model.Departamento;
import com.example.assesment0624.service.DepartamentoService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartamentoController.class)
@AutoConfigureMockMvc(addFilters = false)
public class DepartamentoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void novoDepartamento() throws Exception {
        Departamento departamento = new Departamento();
        departamento.setId(1);
        departamento.setNome("FIN");

        given(departamentoService.salvar(any(Departamento.class))).willReturn(departamento);

        mockMvc.perform(post("/departamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(departamento)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("FIN"));
    }

    @Test
    public void removerDepartamento() throws Exception {
        mockMvc.perform(delete("/departamento/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void listarDepartamentos() throws Exception {
        Departamento departamento2 = new Departamento();
        departamento2.setId(12);
        departamento2.setNome("TI");

        given(departamentoService.buscarDepartamentos()).willReturn(Arrays.asList(departamento2));

        mockMvc.perform(get("/departamento"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("TI"));
    }

    @Test
    public void atualizarDepartamento() throws Exception {
        Departamento departamento3 = new Departamento();
        departamento3.setId(1);
        departamento3.setNome("RH");

        given(departamentoService.atualizar(anyLong(), any(Departamento.class))).willReturn(departamento3);

        mockMvc.perform(put("/departamento/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(departamento3)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("RH"));

    }

}
