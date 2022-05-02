package com.proyecto.apiatencionmedica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyecto.apiatencionmedica.controllers.SignoVitalController;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.reponseDTO.SignoVitalDTO;
import com.proyecto.apiatencionmedica.services.SignoVitalService;

@ExtendWith(MockitoExtension.class)
public class SignoVitalControllerTest {

	@InjectMocks
	SignoVitalController svController;
	
	@Mock
	SignoVitalService svService;
	
	@Test
	void test_listarSignosVitalesOk() {
		List<SignoVitalDTO> lista = new ArrayList<>();
		Mockito.when(svService.listarSignosVitales()).thenReturn(lista);		
		assertEquals(lista, svController.listarSignosVitales());		
	}
	@Test
	void test_listarSignosVitalesPorPacienteOk() {
		List<SignoVitalDTO> lista = new ArrayList<>();
		Paciente paciente = new Paciente();
		Mockito.when(svService.listarSignosVitalesPorPaciente(paciente)).thenReturn(lista);		
		assertEquals(lista, svController.listarSignosVitalesPorPaciente(paciente));	
	}
	@Test
	void test_actualizarSignosVitalesCreated() {
		List<SignoVitalDTO> lista = new ArrayList<>();
		SignoVital sv = new SignoVital();
		Mockito.when(svService.actualizarSignosVitales(sv, 1)).thenReturn(lista);
		ResponseEntity<?> rs = svController.actualizarSignosVitales(sv, 1);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	@Test
	void test_actualizarSignosVitalesNotFound() {		
		SignoVital sv = new SignoVital();
		Mockito.when(svService.actualizarSignosVitales(sv, 1)).thenReturn(null);
		ResponseEntity<?> rs = svController.actualizarSignosVitales(sv, 1);
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	@Test
	void test_eliminarSignoVital() {
		doNothing().when(svService).eliminarSignoVital(1);
		svController.eliminarSignoVital(1);
		verify(svService,times(1)).eliminarSignoVital(1);
		
	}
}
