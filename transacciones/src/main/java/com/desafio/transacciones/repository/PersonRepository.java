package com.desafio.transacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafio.transacciones.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	List<Person> findAll();

}
