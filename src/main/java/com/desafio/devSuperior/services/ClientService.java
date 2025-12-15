package com.desafio.devSuperior.services;

import org.springframework.stereotype.Service;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.repository.ClientRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    public final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return new ClientDTO(repository.findById(id).get());}
}
