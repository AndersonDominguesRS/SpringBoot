package com.example.alunoreactive;

import com.example.alunoreactive.controller.AlunoController;
import com.example.alunoreactive.model.Aluno;
import com.example.alunoreactive.repository.AlunoRepository;
import com.example.alunoreactive.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@WebFluxTest(AlunoController.class)
public class AlunoTest {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private AlunoService alunoService;

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new Aluno(1, "NOME DE TESTE");
    }

    @Test
    public void testFindAll(){
        doReturn(Flux.just(aluno)).when(alunoService).getAlunos();

        webClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Aluno.class)
                .hasSize(1)
                .contains(aluno);

        verify(alunoService, times(1)).getAlunos();

    }

    @Test
    public void testFindById(){
        doReturn(Mono.just(aluno)).when(alunoService).getAlunoId(1);
        webClient.get().uri("/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Aluno.class)
                .isEqualTo(aluno);

        verify(alunoService, times(1)).getAlunoId(1);
    }
    @Test
    public void testeSalvar(){
        Aluno aluno1=new Aluno(null, "Aluno");
        Aluno aluno2=new Aluno(2, "Aluno");

        doReturn(Mono.just(aluno2)).when(alunoService).saveAluno(aluno1);

        webClient.post().uri("/")
                .bodyValue(aluno1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Aluno.class)
                .isEqualTo(aluno2);

        verify(alunoService, times(1)).saveAluno(aluno1);

    }

    @Test
    public void testeDelete(){
        doReturn(Mono.empty()).when(alunoService).deleteAluno(1);

        webClient.delete().uri("/1")
                .exchange()
                .expectStatus().isOk();

        verify(alunoService, times(1)).deleteAluno(1);

    }

}
