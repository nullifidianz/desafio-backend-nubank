package com.nullifidianz.desafio_backend_nubank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DesafioBackendNubankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackendNubankApplication.class, args);
	}

}
