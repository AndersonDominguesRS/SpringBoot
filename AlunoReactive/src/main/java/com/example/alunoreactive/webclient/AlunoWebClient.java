package com.example.alunoreactive.webclient;

import com.example.alunoreactive.model.Aluno;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlunoWebClient {

    private final WebClient webClient;


    public AlunoWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8099/").build();
    }

    public Flux<Aluno> findAll() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(Aluno.class);
    }

    public Mono<Aluno> findById(String id) {
        return webClient.get()
                .uri("/{id}")
                .retrieve()
                .bodyToMono(Aluno.class);
    }
}
