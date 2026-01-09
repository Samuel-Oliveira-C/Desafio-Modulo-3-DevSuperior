package com.desafio.devSuperior.controllers.handlers;

import java.lang.reflect.Field;
import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.devSuperior.model.exceptions.CustomExceptions;
import com.desafio.devSuperior.model.exceptions.CustomValidationException;
import com.desafio.devSuperior.model.exceptions.FieldMessage;
import com.desafio.devSuperior.services.exceptions.ResourceNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlersExceptions {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<CustomExceptions> resourceNotFound(ResourceNotFound error, HttpServletRequest request){
        CustomExceptions customExceptions = new CustomExceptions(
            Instant.now(),
            404,
            error.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(404).body(customExceptions);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptions> validationErrors(MethodArgumentNotValidException error, HttpServletRequest request){
        CustomValidationException customError = new CustomValidationException(
            Instant.now(), 
            422, 
            "Dados inválidos", 
            request.getRequestURI());
        for(FieldError f: error.getBindingResult().getFieldErrors()){
            customError.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(422).body(customError);
    }

}
