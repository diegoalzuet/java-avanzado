package com.proyecto.apiatencionmedica.repositories;

import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignoVitalRepository extends CrudRepository<SignoVital,Integer> {

    public List<SignoVital> findAll();

    public List<SignoVital> findByPaciente(Paciente paciente);
}
