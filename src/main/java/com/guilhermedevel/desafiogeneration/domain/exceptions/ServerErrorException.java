package com.guilhermedevel.desafiogeneration.domain.exceptions;

import lombok.Getter;

public class ServerErrorException extends RuntimeException {

    @Getter
    private final transient Issue issue;

    public ServerErrorException(Issue issue) {
        super(issue.getMessage());
        this.issue = issue;
    }
}
