package com.desafio.devSuperior.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.model.entity.Client;
import com.desafio.devSuperior.repository.ClientRepository;
import com.desafio.devSuperior.services.exceptions.ResourceNotFound;

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

    @Transactional
    public ClientDTO saveEntity(ClientDTO dto){
        Client entity = new Client();
        copyEntityToDto(entity, dto);
        return new ClientDTO(repository.save(entity));
    }

    @Transactional
    public ClientDTO updateEntity(Long id, ClientDTO dto){
        if(!repository.existsById(id)){
            throw new ResourceNotFound("Recurso não encontrado.");
        }
        else{
        Client entity = repository.getReferenceById(id);
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new ClientDTO(entity);
        }
    }

    @Transactional
    public void deleteEntity(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFound("Recurso não encontrado.");
        }else{
            repository.deleteById(id);
        }
    }

    public ClientDTO copyEntityToDto(Client entity, ClientDTO dto){
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setBirthDate(dto.birthDate());
        entity.setChildren(dto.children());
        return new ClientDTO(entity);
    }
}
