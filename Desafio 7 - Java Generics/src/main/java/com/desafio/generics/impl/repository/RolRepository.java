package com.desafio.generics.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.generics.impl.entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Integer> {
}
