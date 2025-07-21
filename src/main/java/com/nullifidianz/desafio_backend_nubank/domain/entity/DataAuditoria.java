package com.nullifidianz.desafio_backend_nubank.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class DataAuditoria {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataInclusao;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

}
