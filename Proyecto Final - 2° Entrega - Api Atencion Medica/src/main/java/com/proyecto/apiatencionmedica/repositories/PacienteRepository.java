package com.proyecto.apiatencionmedica.repositories;

import com.proyecto.apiatencionmedica.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<Paciente,Integer> {

    public List<Paciente> findAll();

    public Paciente findByNombreCompleto(String nombreCompleto);
}
