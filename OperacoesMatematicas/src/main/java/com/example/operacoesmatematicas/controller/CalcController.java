package com.example.operacoesmatematicas.controller;

import com.example.operacoesmatematicas.model.Calculadora;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalcController {
    @GetMapping("/alomundo2")
    String alomundo(){
        return "Alo mundo";
    }

    @GetMapping("/soma1/{n1}/{n2}")
    String soma(@PathVariable int n1, @PathVariable int n2){
        return String.valueOf(n1 + n2);
    }

    @PostMapping("/soma")
    Integer calcularSoma(@RequestBody Calculadora calculadora){
        int resultado=calculadora.getNum1() + calculadora.getNum2();
        return resultado;
    }
    @GetMapping("/dividi1/{n1}/{n2}")
    String dividi(@PathVariable int n1, @PathVariable int n2){
        return String.valueOf(n1 / n2);
    }

    @PostMapping("/dividi")
    Integer calculardividi(@RequestBody Calculadora calculadora){
        int resultado=calculadora.getNum1() / calculadora.getNum2();
        return resultado;
    }

    @GetMapping("/multiplica1/{n1}/{n2}")
    String multiplica(@PathVariable int n1, @PathVariable int n2){
        return String.valueOf(n1 * n2);
    }

    @PostMapping("/multiplica")
    Integer calcularmultiplica(@RequestBody Calculadora calculadora){
        int resultado=calculadora.getNum1() * calculadora.getNum2();
        return resultado;
    }

    @GetMapping("/diminui1/{n1}/{n2}")
    String diminui(@PathVariable int n1, @PathVariable int n2){
        return String.valueOf(n1 - n2);
    }

    @PostMapping("/diminui")
    Integer calculardiminui(@RequestBody Calculadora calculadora){
        int resultado=calculadora.getNum1() - calculadora.getNum2();
        return resultado;
    }

    @GetMapping("/potencia1/{n1}/{n2}")
    String potencia(@PathVariable int n1, @PathVariable int n2){
        int resultado=0;
        for(int i = 0; i <= n2; i++){
            resultado = (int)Math.pow(2, i);
        }
        return String.valueOf(resultado);
    }

    @PostMapping("/potencia")
    Integer calcularpotencia(@RequestBody Calculadora calculadora){
        int resultado=0;
        for(int i = 0; i <= calculadora.getNum2(); i++){
            resultado = (int)Math.pow(2, i);
        }
        return resultado;
    }
}
