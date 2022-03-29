package com.desafio.generics.impl.repository;


import org.springframework.stereotype.Repository;
import com.desafio.generics.generic.repository.GenericRepository;
import com.desafio.generics.impl.entity.User;

@Repository
public interface UserRepository extends GenericRepository<User,Long>  {

}
