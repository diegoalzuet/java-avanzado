package com.desafio.generics.generic.entity;

public interface GenericEntity<T,ID> {
	
	ID getId();		
	void crear();
	void actualizar(T nuevo);
	void eliminar();

}
