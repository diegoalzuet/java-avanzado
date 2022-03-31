package com.proyecto.apiatencionmedica.repositories;

import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.generic.repository.GenericRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends GenericRepository<Paciente,Integer> {

    public List<Paciente> findAll();

    public Paciente findByNombreCompleto(String nombreCompleto);
}
