package com.nullifidianz.desafio_backend_nubank.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteRequest;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ClienteResponse;
import com.nullifidianz.desafio_backend_nubank.domain.dto.ContatoDTO;
import com.nullifidianz.desafio_backend_nubank.domain.entity.Cliente;
import com.nullifidianz.desafio_backend_nubank.domain.entity.Contato;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequest request) {

        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setDataNascimento(request.dataNascimento());
        cliente.setDocumento(request.documento());

        if (request.contatos() != null) {
            List<Contato> contatos = request.contatos().stream().map(m -> {
                Contato contato = new Contato();
                contato.setTelefone(m.telefone());
                contato.setEmail(m.email());
                contato.setCliente(cliente);
                return contato;

            }).toList();
            cliente.setContatos(contatos);
        }

        return cliente;
    }

    public Contato toEntity(ContatoDTO dto, Cliente cliente){
        Contato contato  = new Contato();
        contato.setTelefone(dto.telefone());
        contato.setEmail(dto.email());
        contato.setCliente(cliente);
        return contato;
    }

    public ClienteResponse toResponse(Cliente cliente) {
        List<ContatoDTO> contatos;

        if (cliente.getContatos() != null) {
            contatos = cliente.getContatos().stream().map(m -> {
                ContatoDTO contatoDTO = new ContatoDTO(m.getTelefone(), m.getEmail());
                return contatoDTO;
            }).toList();
        } else {
            contatos = List.of();
        }

        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getDataNascimento(),
                cliente.getDocumento(), contatos);
    }

}
