package com.guilhermedevel.desafiogeneration.rest.exceptions;

import com.guilhermedevel.desafiogeneration.domain.exceptions.Issue;
import com.guilhermedevel.desafiogeneration.domain.exceptions.IssueEnum;
import com.guilhermedevel.desafiogeneration.domain.exceptions.ObjectNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Issue handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new Issue(IssueEnum.ARGUMENT_NOT_VALID,
                e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Issue handlerObjectNotFoundException(ObjectNotFoundException e){
        return e.getIssue();
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Issue handlerHttpServerErrorException(HttpServerErrorException.InternalServerError e){
        return new Issue(IssueEnum.INTERNAL_SERVER_ERROR, e.getMessage().split(":")[0]);
    }
}
