package com.desafio.generics.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.generics.impl.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
