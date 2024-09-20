package com.example.veiculor2dbc.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String mensagem) {
        super(mensagem);
    }
}
