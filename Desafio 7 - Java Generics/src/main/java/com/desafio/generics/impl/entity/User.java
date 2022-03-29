package com.desafio.generics.impl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.generics.generic.entity.GenericEntity;

@Entity
@Table(name = "user")
public class User implements GenericEntity<User, Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Boolean activo;
	
	public User() {}

	public User(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}	
	
	@Override
	public Long getId() {		
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void crear() {
		this.activo = true;
		
	}
	
	@Override
	public void eliminar() {
		this.activo = false;		
	}	

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public void actualizar(User nuevo) {
		this.nombre = nuevo.nombre;		
	}	
	
}
