package com.desafio.devSuperior.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.services.ClientService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @GetMapping
    public Page<ClientDTO> findAllBySorting(Pageable list){
        return service.findAllBySorting(list);
    }
    
    @PostMapping
    public ClientDTO saveEntity (@Valid @RequestBody ClientDTO dto){
        return service.saveEntity(dto);
    }
    
    @PutMapping("/{id}")
    public String update(@Valid @PathVariable Long id, @RequestBody ClientDTO dto) {
        service.updateEntity(id, dto);
        return "Client atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteEntity(id);
    }
}
