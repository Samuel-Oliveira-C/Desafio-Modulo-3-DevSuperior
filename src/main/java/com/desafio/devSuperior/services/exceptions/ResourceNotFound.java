package com.desafio.devSuperior.services.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String msg) {
        super(msg);
    }
}
