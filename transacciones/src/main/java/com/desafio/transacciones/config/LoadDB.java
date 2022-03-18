package com.desafio.transacciones.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.desafio.transacciones.entity.Person;
import com.desafio.transacciones.repository.PersonRepository;

@Configuration
public class LoadDB {
	
	@Bean
	CommandLineRunner initDB(PersonRepository personRepository) {
		Person person1 = new Person("Diego",34,"Diegote");
		Person person2 = new Person("Marcelo",44,"Muñeco");
		Person person3 = new Person("Carolina",24,"Picante");
		
		return args -> personRepository.saveAll(Arrays.asList(person1,person2,person3)) ;
	}

}
