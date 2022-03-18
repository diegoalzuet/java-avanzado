package com.desafio.transacciones.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.transacciones.entity.Person;
import com.desafio.transacciones.repository.PersonRepository;


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> persons(){
		return personRepository.findAll();
	}
	
	@Transactional(rollbackFor = SQLException.class , propagation = Propagation.REQUIRES_NEW)
	public void createPersonRollback(Person person) throws SQLException {
		personRepository.save(person);
		person.setAge(55);
		personRepository.save(person);
		throw new SQLException("Se lanza excepcion para iniciar el rollback");
	}
	
//	@Transactional(rollbackFor = DataIntegrityViolationException.class , propagation = Propagation.REQUIRES_NEW)
	@Transactional(rollbackFor = PropertyValueException.class , propagation = Propagation.REQUIRES_NEW)
	public void addListPersonRollback(List<Person> persons) {
		personRepository.saveAll(persons);	
	}
}
