package com.desafio.devSuperior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.devSuperior.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
