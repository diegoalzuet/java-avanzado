package com.proyecto.apiatencionmedica.generic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.proyecto.apiatencionmedica.generic.entity.GenericEntity;
import com.proyecto.apiatencionmedica.generic.repository.GenericRepository;

public class GenericService<T extends GenericEntity<T, ID>,ID> {
	
	//private final JpaRepository<T, ID> repository;
	protected final GenericRepository<T, ID> repository;
	
	public GenericService(GenericRepository<T, ID> repository) {
		this.repository = repository;
	}
	
	public Page<T> list(){
		return this.repository.findAll(Pageable.unpaged());
	}
	
	public Long count() {
		return this.repository.count();
	}
		
	public void deleteById(ID id) {
		T anterior = this.repository.findById(id).orElse(null);
		if(anterior==null) return ;
		this.repository.deleteById(id);		
	}

}
