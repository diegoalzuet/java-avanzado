package com.desafio.generics.generic.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.desafio.generics.generic.entity.GenericEntity;
import com.desafio.generics.generic.service.GenericService;

public class GenericController<T extends GenericEntity<T, ID>,ID>{
	
	private final GenericService<T, ID> genericService;
	
	protected GenericController(GenericService<T,ID> service) {
		this.genericService = service;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	@ResponseStatus(HttpStatus.OK)
	public T getById(@PathVariable ID id) {
		return this.genericService.getById(id);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public Page<T> getAll(){
		return this.genericService.list();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	@ResponseStatus(HttpStatus.CREATED)
	public T create(@RequestBody T nuevo) {
		return this.genericService.create(nuevo);
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public T update(@RequestBody T nuevo) {
		return this.genericService.update(nuevo);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@PathVariable ID id) {
		this.genericService.delete(id);
	}

	
}
