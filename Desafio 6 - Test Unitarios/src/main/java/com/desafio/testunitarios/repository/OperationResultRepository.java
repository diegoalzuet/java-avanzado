package com.desafio.testunitarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.testunitarios.domain.entity.OperationResultEntity;

public interface OperationResultRepository extends JpaRepository<OperationResultEntity, Long>{

}
