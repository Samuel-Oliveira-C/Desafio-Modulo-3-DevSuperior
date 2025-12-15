package com.desafio.devSuperior.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.devSuperior.model.dto.ClientDTO;
import com.desafio.devSuperior.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    public final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
}
