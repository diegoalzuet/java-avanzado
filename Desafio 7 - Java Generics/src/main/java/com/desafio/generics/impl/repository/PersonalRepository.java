package com.desafio.generics.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.generics.impl.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal,String> {
}
