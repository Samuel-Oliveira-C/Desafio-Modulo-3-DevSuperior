package com.desafio.devSuperior.model.dto;

import java.time.LocalDate;

import com.desafio.devSuperior.model.entity.Client;

public record ClientDTO(
    Long id, 
    String name, 
    String cpf, 
    Double income, 
    LocalDate birthDate, 
    Integer children) {
    
    public ClientDTO(Client entity) {
        this(
            entity.getId(),
            entity.getName(),
            entity.getCpf(),
            entity.getIncome(),
            entity.getBirthDate(),
            entity.getChildren()
        );
    }
}
