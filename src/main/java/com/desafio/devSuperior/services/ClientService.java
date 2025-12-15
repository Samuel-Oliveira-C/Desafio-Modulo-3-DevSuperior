package com.desafio.devSuperior.services;

import org.springframework.stereotype.Service;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.repository.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
    public final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClientDTO findById(Long id) {
        return new ClientDTO(repository.findById(id).get());}
}
