package com.nullifidianz.desafio_backend_nubank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteRequest;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteResponse;
import com.nullifidianz.desafio_backend_nubank.domain.entity.Cliente;
import com.nullifidianz.desafio_backend_nubank.domain.mapper.ClienteMapper;
import com.nullifidianz.desafio_backend_nubank.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteResponse cadastrarCliente(ClienteRequest request) {
        Cliente cliente = clienteMapper.toEntity(request);
        clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

    public List<ClienteResponse> listarTodos(ClienteResponse response) {
        return clienteRepository.findAll().stream().map(clienteMapper::toResponse).toList();
    }

}
