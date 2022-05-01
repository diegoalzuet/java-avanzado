package com.proyecto.apiatencionmedica.repositories;

import com.proyecto.apiatencionmedica.entities.Role;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
	
	public Optional<Role> findByAuthority(String roleName);
}
