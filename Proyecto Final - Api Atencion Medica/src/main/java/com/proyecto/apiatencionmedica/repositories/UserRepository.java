package com.proyecto.apiatencionmedica.repositories;

import com.proyecto.apiatencionmedica.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
	
	public Optional<User> findByUsername(String username);
}
