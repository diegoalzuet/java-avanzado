package com.proyecto.apiatencionmedica.controllers;

import com.proyecto.apiatencionmedica.controllers.reponseDTO.PacienteDTO;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    //MUESTRA TODOS LOS PACIENTES
    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping
    public List<PacienteDTO> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    //MUESTRA LOS DATOS DE UN PACIENTE SOLICITADO POR EL ID
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/buscarPorId/{idPaciente}")
    public PacienteDTO obtenerPacientePorId(@PathVariable Integer idPaciente){
        return pacienteService.obtenerPacientePorId(idPaciente);
    }

    //MUESTRA LOS DATOS DE UN PACIENTE SOLICITADI POR EL NOMBRE
    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/buscarPorNombre/{nombrePaciente}")
    public PacienteDTO obtenerPacientePorNombre(@PathVariable String nombrePaciente){
        return pacienteService.obtenerPacientePorNombre(nombrePaciente);
    }

    //AGREGA UN PACIENTE NUEVO
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @PostMapping("/agregarPaciente")
    public PacienteDTO agregarPaciente(@RequestBody Paciente pacienteNuevo){
        return pacienteService.agregarPaciente(pacienteNuevo);
    }
    
    //AGREGA UNA LISTA DE PACIENTES
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/agregarPacientes")
    public List<PacienteDTO> agregarListaPacientes(@RequestBody List<Paciente> lista){
    	return pacienteService.agregarListaPacientes(lista);
    }
    //AGREGA UN SIGNO VITAL A UN PACIENTE
    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @PutMapping("/agregarSignoVitalAPaciente/{idPaciente}")
    public PacienteDTO agregarSignoVital(@PathVariable Integer idPaciente, @RequestBody SignoVital signoVitalNuevo){
        return pacienteService.agregarSignoVital(idPaciente, signoVitalNuevo);
    }

    //ACTUALIZA EL NOMBRE Y LA FECHA DE NACIMIENTO DE UN PACIENTE
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/actualizarPaciente/{idPaciente}")
    public PacienteDTO actualizarPaciente(@PathVariable Integer idPaciente, @RequestBody Paciente pacienteActualizado){
        return pacienteService.actualizarPaciente(idPaciente, pacienteActualizado);
    }

    //BORRAR UN PACIENTE Y SUS SIGNOS VITALES
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/borrarPaciente/{idPaciente}")
    public void borrarPaciente(@PathVariable Integer idPaciente){
        pacienteService.borrarPaciente(idPaciente);
    }
    
    //BORRAR UN PACIENTE Y SUS SIGNOS VITALES (GENERIC)
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/borrarPacienteG/{idPaciente}")
    public void borrarPacienteG(@PathVariable Integer idPaciente){
        pacienteService.deleteById(idPaciente);
    }
    
    //COUNT (GENERIC)
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/count")
    public Long count() {
    	return pacienteService.count();
    }
    
}
