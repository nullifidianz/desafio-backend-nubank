package com.nullifidianz.desafio_backend_nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nullifidianz.desafio_backend_nubank.domain.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
