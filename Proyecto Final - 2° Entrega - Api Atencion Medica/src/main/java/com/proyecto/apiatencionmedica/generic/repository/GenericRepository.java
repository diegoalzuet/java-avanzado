package com.proyecto.apiatencionmedica.generic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.proyecto.apiatencionmedica.generic.entity.GenericEntity;



@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T, ID>,ID> extends JpaRepository<T, ID> {

}
