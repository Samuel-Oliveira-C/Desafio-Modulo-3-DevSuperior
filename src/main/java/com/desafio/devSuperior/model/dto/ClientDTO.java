package com.desafio.devSuperior.model.dto;

import java.time.LocalDate;

import com.desafio.devSuperior.model.entity.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ClientDTO(
    Long id, 
    
    @NotBlank(message = "Campo Obrigatório") 
    @Size(min = 4, max = 90, message = "O nome deve conter 3 a 80 caracteres")
    String name, 

    @Size(min = 11, max =11)
    @NotBlank(message = "Campo obrigatório")
    String cpf, 

    @Positive(message = "O Salário deve ser positivo")
    Double income, 
    
    LocalDate birthDate, 
    
    @Positive(message = "O número deve ser positivo")
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