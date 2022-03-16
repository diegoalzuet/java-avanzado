package com.proyecto.apiatencionmedica.services;

import com.proyecto.apiatencionmedica.controllers.reponseDTO.PacienteDTO;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.repositories.PacienteRepository;
import com.proyecto.apiatencionmedica.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDTO> listarPacientes(){
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .collect(Collectors.toList());
    }

    public PacienteDTO obtenerPacientePorId( Integer idPaciente){
        Paciente buscado = pacienteRepository.findById(idPaciente).orElse(null);
        if(buscado!=null)
            return  new PacienteDTO(buscado);
        return null;
    }

    public PacienteDTO obtenerPacientePorNombre( String nombrePaciente) {
        Paciente buscado = pacienteRepository.findByNombreCompleto(nombrePaciente);
        if (buscado != null)
            return new PacienteDTO(buscado);
        return null;
    }

    public PacienteDTO agregarPaciente( Paciente pacienteNuevo){
        pacienteNuevo.getSignosVitales().forEach(signoVital -> {
            signoVital.setPaciente(pacienteNuevo);
        });
        return new PacienteDTO(pacienteRepository.save(pacienteNuevo));
    }

    public PacienteDTO agregarSignoVital( Integer idPaciente,  SignoVital signoVitalNuevo){
        Paciente pacientaActualizar = pacienteRepository.findById(idPaciente).orElse(null);
        if(pacientaActualizar!=null)
        {
            pacientaActualizar.addSignoVital(signoVitalNuevo);
            return new PacienteDTO(pacienteRepository.save(pacientaActualizar));
        }
        return null;
    }

    public PacienteDTO actualizarPaciente( Integer idPaciente,  Paciente pacienteActualizado){
        Paciente pacienteAActualizar = pacienteRepository.findById(idPaciente).orElse(null);
        if(pacienteAActualizar!=null){
            pacienteAActualizar.setNombreCompleto(pacienteActualizado.getNombreCompleto());
            pacienteAActualizar.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
            return new PacienteDTO(pacienteAActualizar);
        }
        return null;
    }

    public void borrarPaciente( Integer idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }

}
