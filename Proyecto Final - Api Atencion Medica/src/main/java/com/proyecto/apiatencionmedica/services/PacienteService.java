package com.proyecto.apiatencionmedica.services;

import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.generic.service.GenericService;
import com.proyecto.apiatencionmedica.reponseDTO.PacienteDTO;
import com.proyecto.apiatencionmedica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService extends GenericService<Paciente, Integer> {

	
	private PasswordEncoder passwordEncoder;

	@Autowired
	public PacienteService(PacienteRepository pacienteRepository, PasswordEncoder passwordEncoder) {
		super(pacienteRepository);
		this.passwordEncoder = passwordEncoder;
	}

	public List<PacienteDTO> listarPacientes() {
		return repository.findAll()
				.stream()
				.map(PacienteDTO::new)
				.collect(Collectors.toList());
	}

	public PacienteDTO obtenerPacientePorId(Integer idPaciente) {
		Paciente buscado = repository.findById(idPaciente).orElse(null);
		if (buscado != null)
			return new PacienteDTO(buscado);
		return null;
	}

	public PacienteDTO obtenerPacientePorNombre(String nombrePaciente) {
		Paciente buscado = ((PacienteRepository) repository).findByNombreCompleto(nombrePaciente);
		if (buscado != null)
			return new PacienteDTO(buscado);
		return null;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public PacienteDTO agregarPaciente(Paciente pacienteNuevo) {
		User username = new User(pacienteNuevo.getNombreCompleto().replaceAll(" ", "").toLowerCase(),
				passwordEncoder.encode(pacienteNuevo.getNombreCompleto().replaceAll(" ", "").toLowerCase()), true,
				Arrays.asList(new Role("ROLE_USER")));
		username.getRoles().get(0).setUsername(username);
		pacienteNuevo.setUsername(username);
		username.setPaciente(pacienteNuevo);

		pacienteNuevo.getSignosVitales().forEach(signoVital -> {
			signoVital.setPaciente(pacienteNuevo);
		});
		return new PacienteDTO(repository.save(pacienteNuevo));
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public List<PacienteDTO> agregarListaPacientes(List<Paciente> listaNueva) {
		List<PacienteDTO> lista = new ArrayList<>();	
		listaNueva.forEach(paciente -> {
			if (paciente.getId() == null)
				lista.add(this.agregarPaciente(paciente));
			else
			{
				PacienteDTO dto =this.actualizarPaciente(paciente.getId(), paciente);
				if (dto!=null) 
					lista.add(dto);
			}
		});
		
		return lista;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public PacienteDTO agregarSignoVital(Integer idPaciente, SignoVital signoVitalNuevo) {
		Paciente pacientaActualizar = repository.findById(idPaciente).orElse(null);
		if (pacientaActualizar != null) {
			pacientaActualizar.addSignoVital(signoVitalNuevo);
			return new PacienteDTO(repository.save(pacientaActualizar));
		}
		return null;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public PacienteDTO actualizarPaciente(Integer idPaciente, Paciente pacienteActualizado) {
		Paciente pacienteAActualizar = repository.findById(idPaciente).orElse(null);
		if (pacienteAActualizar != null) {
			pacienteAActualizar.setNombreCompleto(pacienteActualizado.getNombreCompleto());
			pacienteAActualizar.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());		
//			return new PacienteDTO(repository.save(pacienteAActualizar));
			return (this.agregarPaciente(pacienteAActualizar));
		}
		return null;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public boolean borrarPaciente(Integer idPaciente) {
		if(repository.existsById(idPaciente))
		{
			repository.deleteById(idPaciente);
			return true;
		}		
		return false;
	}

}
