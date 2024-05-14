package com.example.produtostp2.controller;

import com.example.produtostp2.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    private ProdutoController(){
        produtos.addAll(List.of(
            new Produto(1, "Bala"),
            new Produto(2, "Tela")
        ));
    }


    @GetMapping("/lista")
    Iterable<Produto> get(){
        return produtos;
    }

    @GetMapping("/produto/{id}")
    Produto getProdutosId(@PathVariable int id){
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @PostMapping("/produtoIncluir")
    Produto addProduto(@RequestBody Produto produto){
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/produtoAtualiza/{id}")
    Produto updateProduto(@PathVariable int id,  @RequestBody Produto produto){
        int alunoIndex=-1;
        for (Produto aluno1 : produtos) {
            if (aluno1.getId() == id) {
                alunoIndex= produtos.indexOf(aluno1);
                produtos.set(alunoIndex,produto);
            }
        }
        return (alunoIndex == -1) ? addProduto(produto) : produto;
    }

    @DeleteMapping("/delProduto/{id}")
    String deleteProduto(@PathVariable int id){
        produtos.removeIf(produto -> produto.getId() == id);
        return "Produto removido com sucesso!";
    }
}
