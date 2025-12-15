package com.desafio.devSuperior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.devSuperior.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
