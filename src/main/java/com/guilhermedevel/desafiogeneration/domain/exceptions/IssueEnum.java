package com.guilhermedevel.desafiogeneration.domain.exceptions;

public enum IssueEnum {

    OBJECT_NOT_FOUND("O objeto da requisição não pode ser encontrado no banco de dados."),
    ARGUMENT_NOT_VALID("Um erro aconteceu durante a validação do corpo da requisição."),
    INTERNAL_SERVER_ERROR("Servidor instável no momento");


    private final String message;

    IssueEnum(String message) { this.message = message; }

    public String getMessage() { return message; }
}
