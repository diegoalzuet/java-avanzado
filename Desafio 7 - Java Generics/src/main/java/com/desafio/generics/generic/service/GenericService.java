package com.desafio.generics.generic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.generics.generic.entity.GenericEntity;
import com.desafio.generics.generic.repository.GenericRepository;


public class GenericService<T extends GenericEntity<T, ID>,ID> {
	
	//private final JpaRepository<T, ID> repository;
	private final GenericRepository<T, ID> repository;
	
	public GenericService(GenericRepository<T, ID> repository) {
		this.repository = repository;
	}
	
	public T getById(ID id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Page<T> list(){
		return this.repository.findAll(Pageable.unpaged());
	}
		
	public T create(T toCreate) {	
		toCreate.crear();
		return repository.save(toCreate);		
	}
	
	public T update(T toUpdate) {
		T anterior = this.repository.findById(toUpdate.getId()).orElse(null);
		if(anterior==null) return null;
		anterior.actualizar(toUpdate);
		return this.repository.save(anterior);
	}
	
	public void delete(ID id) {
		T anterior = this.repository.findById(id).orElse(null);
		if(anterior==null) return ;
		
		anterior.eliminar();
		this.repository.save(anterior);
		
	}

}
