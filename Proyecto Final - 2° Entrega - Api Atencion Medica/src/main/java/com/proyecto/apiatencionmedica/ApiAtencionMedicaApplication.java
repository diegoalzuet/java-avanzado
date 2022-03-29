package com.proyecto.apiatencionmedica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ApiAtencionMedicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAtencionMedicaApplication.class, args);
	}

}
