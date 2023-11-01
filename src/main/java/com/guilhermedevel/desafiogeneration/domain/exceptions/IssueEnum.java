package com.guilhermedevel.desafiogeneration.domain.exceptions;

public enum IssueEnum {

    OBJECT_NOT_FOUND("O objeto da requisição não pode ser encontrado no banco de dados.");

    private final String message;

    IssueEnum(String message) { this.message = message; }

    public String getMessage() { return message; }
}
