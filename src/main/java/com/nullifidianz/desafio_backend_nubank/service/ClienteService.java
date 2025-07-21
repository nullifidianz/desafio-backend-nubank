package com.nullifidianz.desafio_backend_nubank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteRequest;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteResponse;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ContatoDTO;
import com.nullifidianz.desafio_backend_nubank.domain.entity.Cliente;
import com.nullifidianz.desafio_backend_nubank.domain.entity.Contato;
import com.nullifidianz.desafio_backend_nubank.domain.mapper.ClienteMapper;
import com.nullifidianz.desafio_backend_nubank.repository.ClienteRepository;
import com.nullifidianz.desafio_backend_nubank.repository.ContatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;
    private final ClienteMapper clienteMapper;

    public ClienteResponse cadastrarCliente(ClienteRequest request) {
        Cliente cliente = clienteMapper.toEntity(request);
        clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

    public List<ClienteResponse> listarTodosClientes(ClienteResponse response) {
        return clienteRepository.findAll().stream().map(clienteMapper::toResponse).toList();
    }

    public List<ContatoDTO> listarContatos(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        return cliente.getContatos().stream().map(contato -> new ContatoDTO(contato.getTelefone(), contato.getEmail())).toList();
    }


    public ClienteResponse cadastrarContato(Long id, ContatoDTO dto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        Contato contato = clienteMapper.toEntity(dto, cliente);
        cliente.getContatos().add(contato);
        contatoRepository.save(contato);

        return clienteMapper.toResponse(cliente);


    } 
}
