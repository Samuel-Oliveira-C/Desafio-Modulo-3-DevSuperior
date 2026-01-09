package com.desafio.devSuperior.model.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomValidationException extends CustomExceptions{
    List<FieldMessage> errors = new ArrayList<>();
    
    public CustomValidationException(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors(){
        return errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName,message));
    }
}
