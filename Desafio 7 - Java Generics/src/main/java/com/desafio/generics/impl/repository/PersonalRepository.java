package com.desafio.generics.impl.repository;

import com.desafio.generics.generic.repository.GenericRepository;
import com.desafio.generics.impl.entity.Personal;

public interface PersonalRepository extends GenericRepository<Personal,String> {
}
