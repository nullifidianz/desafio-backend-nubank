package com.nullifidianz.desafio_backend_nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nullifidianz.desafio_backend_nubank.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
