package com.proyecto.apiatencionmedica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyecto.apiatencionmedica.controllers.PacienteController;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.reponseDTO.PacienteDTO;
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
	void test_obtenerPacientePorIdOk() {
		PacienteDTO paciente = new PacienteDTO();
		Mockito.when(pacienteService.obtenerPacientePorId(1)).thenReturn(paciente);
		ResponseEntity<?> rs  = pacienteController.obtenerPacientePorId(1);
		assertEquals(HttpStatus.OK, rs.getStatusCode());
	}
	
	@Test
	void test_obtenerPacientePorIdNotFound() {		
		Mockito.when(pacienteService.obtenerPacientePorId(1)).thenReturn(null);
		ResponseEntity<?> rs  =pacienteController.obtenerPacientePorId(1);
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	@Test
	void test_obtenerPacientePorNombreOk() {
		PacienteDTO paciente = new PacienteDTO();
		Mockito.when(pacienteService.obtenerPacientePorNombre("Diego")).thenReturn(paciente);
		ResponseEntity<?> rs = pacienteController.obtenerPacientePorNombre("Diego");
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		verify(pacienteService,times(1)).obtenerPacientePorNombre("Diego");
	}
	
	@Test
	void test_obtenerPacientePorNombreNotFound() {
		Mockito.when(pacienteService.obtenerPacientePorNombre("Diego")).thenReturn(null);
		ResponseEntity<?> rs =  pacienteController.obtenerPacientePorNombre("Diego");
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
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
	void test_agregarSignoVitalCreated() {
		SignoVital signoVital = new SignoVital();
		Mockito.when(pacienteService.agregarSignoVital(1, signoVital)).thenReturn(new PacienteDTO());
		ResponseEntity<?> rs = pacienteController.agregarSignoVital(1, signoVital);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	@Test
	void test_agregarSignoVitalNotFound() {
		SignoVital signoVital = new SignoVital();
		Mockito.when(pacienteService.agregarSignoVital(1, signoVital)).thenReturn(null);
		ResponseEntity<?> rs = pacienteController.agregarSignoVital(1, signoVital);
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	
	@Test
	void test_actualizarPacienteCreated() {
		Paciente nuevoPaciente = new Paciente();
		Mockito.when(pacienteService.actualizarPaciente(1, nuevoPaciente)).thenReturn(new PacienteDTO());
		ResponseEntity<?> rs = pacienteController.actualizarPaciente(1, nuevoPaciente);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	@Test
	void test_actualizarPacienteNotFound() {
		Paciente nuevoPaciente = new Paciente();
		Mockito.when(pacienteService.actualizarPaciente(1, nuevoPaciente)).thenReturn(null);
		ResponseEntity<?> rs = pacienteController.actualizarPaciente(1, nuevoPaciente);
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	
	@Test
	void test_borrarPacienteNoContent() {
		Mockito.when(pacienteService.borrarPaciente(1)).thenReturn(true);
		ResponseEntity<?> rs = pacienteController.borrarPaciente(1);		
		assertEquals(HttpStatus.NO_CONTENT, rs.getStatusCode());		
	}
	
	@Test
	void test_borrarPacienteNotFound() {
		Mockito.when(pacienteService.borrarPaciente(1)).thenReturn(false);
		ResponseEntity<?> rs = pacienteController.borrarPaciente(1);		
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());		
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
