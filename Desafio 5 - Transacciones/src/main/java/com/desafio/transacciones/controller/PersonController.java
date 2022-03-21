package com.desafio.transacciones.controller;

import java.util.List;
import java.sql.SQLException;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.transacciones.entity.Person;
import com.desafio.transacciones.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> persons(){
		return personService.persons();
	}
	
	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}	
	
	@PostMapping("/personRollback")
	public void createPersonRollback(@RequestBody Person person) throws SQLException {
		personService.createPersonRollback(person);
	}
	
	@PostMapping("/listaConCampoNull")
	public void addListPersonRollback(@RequestBody List<Person> persons) {
		personService.addListPersonRollback(persons);
	}
}
