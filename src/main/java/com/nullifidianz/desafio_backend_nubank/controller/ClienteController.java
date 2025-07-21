package com.nullifidianz.desafio_backend_nubank.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteRequest;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteResponse;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ContatoDTO;

import com.nullifidianz.desafio_backend_nubank.service.ClienteService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


 



@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.cadastrarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    @PostMapping("/contatos/{id}")
    public ResponseEntity<ClienteResponse> cadastrarContato(@PathVariable Long id, @RequestBody ContatoDTO dto) {
        ClienteResponse response = clienteService.cadastrarContato(id, dto);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponse>> listarTodos() {
        
        return ResponseEntity.ok(clienteService.listarTodosClientes());
    }

    @GetMapping("/clientes/{id}/contatos")
    public ResponseEntity<List<ContatoDTO>> getMethodName(Long id) {
        return ResponseEntity.ok(clienteService.listarContatos(id));
    }
    
    
    
    

}
