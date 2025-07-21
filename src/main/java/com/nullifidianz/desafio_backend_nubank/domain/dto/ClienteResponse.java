package com.nullifidianz.desafio_backend_nubank.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record ClienteResponse(Long id, String nome, LocalDate dataNascimento, String documento,
        List<ContatoDTO> contatos) {

}
