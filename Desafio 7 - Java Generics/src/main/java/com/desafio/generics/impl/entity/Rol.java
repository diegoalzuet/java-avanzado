package com.desafio.generics.impl.entity;

import javax.persistence.*;

import com.desafio.generics.generic.entity.GenericEntity;

@Entity
@Table(name = "authorities")
public class Rol implements GenericEntity<Rol, Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private Personal username;

    @Column(name = "authority")
    private String authority;

    public Rol() {
    }

    public Rol(String rol){
        this.username = null;
        this.authority = rol;
    }
    public Rol(Personal username, String rol) {
        this.username = username;
        this.authority = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personal getUsername() {
        return username;
    }

    public void setUsername(Personal username) {
        this.username = username;
    }

    public String getRol() {
        return authority;
    }

    public void setRol(String rol) {
        this.authority = rol;
    }

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Rol nuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}
}
