package com.proyecto.apiatencionmedica;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.proyecto.apiatencionmedica.controllers.PacienteController;
import com.proyecto.apiatencionmedica.controllers.reponseDTO.PacienteDTO;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.services.PacienteService;

@ExtendWith(MockitoExtension.class)
public class PacienteControllerTest {
	
	@InjectMocks
	PacienteController pacienteController;
	
	@Mock
	PacienteService pacienteService;
	
	@Test
	void test_listarPacientes() {
		pacienteController.listarPacientes();
		verify(pacienteService,times(1)).listarPacientes();
	}
	
	@Test
	void test_obtenerPacientePorId() {
		PacienteDTO paciente = new PacienteDTO();
		Mockito.when(pacienteService.obtenerPacientePorId(1)).thenReturn(paciente);
		pacienteController.obtenerPacientePorId(1);
		verify(pacienteService,times(1)).obtenerPacientePorId(1);
	}
	
	@Test
	void test_obtenerPacientePorNombre() {
		PacienteDTO paciente = new PacienteDTO();
		Mockito.when(pacienteService.obtenerPacientePorNombre("Diego")).thenReturn(paciente);
		pacienteController.obtenerPacientePorNombre("Diego");
		verify(pacienteService,times(1)).obtenerPacientePorNombre("Diego");
	}
	
	@Test
	void test_agregarPaciente() {
		Paciente paciente = new Paciente();
		Mockito.when(pacienteService.agregarPaciente(paciente)).thenReturn(new PacienteDTO());
		pacienteController.agregarPaciente(paciente);
		verify(pacienteService,times(1)).agregarPaciente(paciente);
	}
	
	@Test
	void test_agregarListaPacientes() {
		List<Paciente> listaPacientes = Arrays.asList(new Paciente(),new Paciente(),new Paciente());
		List<PacienteDTO> listaPacienteResponse = Arrays.asList(new PacienteDTO(),new PacienteDTO(),new PacienteDTO());
		Mockito.when(pacienteService.agregarListaPacientes(listaPacientes)).thenReturn(listaPacienteResponse);
		pacienteController.agregarListaPacientes(listaPacientes);
		verify(pacienteService,times(1)).agregarListaPacientes(listaPacientes);
	}
	
	@Test
	void test_agregarSignoVital() {
		SignoVital signoVital = new SignoVital();
		Mockito.when(pacienteService.agregarSignoVital(1, signoVital)).thenReturn(new PacienteDTO());
		pacienteController.agregarSignoVital(1, signoVital);
		verify(pacienteService,times(1)).agregarSignoVital(1, signoVital);
	}
	
	@Test
	void test_actualizarPaciente() {
		Paciente nuevoPaciente = new Paciente();
		Mockito.when(pacienteService.actualizarPaciente(1, nuevoPaciente)).thenReturn(new PacienteDTO());
		pacienteController.actualizarPaciente(1, nuevoPaciente);
		verify(pacienteService,times(1)).actualizarPaciente(1, nuevoPaciente);
	}
	
	@Test
	void test_borrarPaciente() {
		doNothing().when(pacienteService).borrarPaciente(1);
		pacienteController.borrarPaciente(1);
		verify(pacienteService,times(1)).borrarPaciente(1);
	}
	
	@Test
	void test_borrarPacienteG(){
		doNothing().when(pacienteService).deleteById(1);
		pacienteController.borrarPacienteG(1);
		verify(pacienteService,times(1)).deleteById(1);
	}
	
	@Test
	void test_count() {
		Mockito.when(pacienteService.count()).thenReturn(1L);
		pacienteController.count();
		verify(pacienteService,times(1)).count();
	}
	
	

}
