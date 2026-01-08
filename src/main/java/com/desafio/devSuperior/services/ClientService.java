package com.desafio.devSuperior.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.model.entity.Client;
import com.desafio.devSuperior.repository.ClientRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return new ClientDTO(repository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllBySorting(Pageable listPageable){
        Page<Client> result = repository.findAll(listPageable);
        return result.map(x -> new ClientDTO(x));
    }
}
