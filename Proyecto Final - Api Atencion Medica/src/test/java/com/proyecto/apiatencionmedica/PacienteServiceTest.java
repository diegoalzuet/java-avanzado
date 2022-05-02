package com.proyecto.apiatencionmedica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.reponseDTO.PacienteDTO;
import com.proyecto.apiatencionmedica.repositories.PacienteRepository;
import com.proyecto.apiatencionmedica.services.PacienteService;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {
	
	@Mock
	PacienteRepository pacienteRepository;
	
	private PacienteService pacienteService;
	
	@BeforeEach
	void Setup() {
		pacienteService = new PacienteService(pacienteRepository);
	}
	
	@Test
	void test_listarPacientes() {
		//Mockito.when(pacienteService.listarPacientes()).thenReturn(Arrays.asList(new PacienteDTO(),new PacienteDTO()));
		pacienteService.listarPacientes();
	}
	
	@Test
	void test_obtenerPacientePorIdNull() {
		//Mockito.when(pacienteRepository.getById(1)).thenReturn(new Paciente());
		pacienteService.obtenerPacientePorId(1);
		verify(pacienteRepository).findById(1);		
	}
	@Test
	void test_obtenerPacientePorIdNotNull() {
		Paciente paciente = new Paciente();
		List<SignoVital> signos = Arrays.asList(new SignoVital(),new SignoVital());
		paciente.setSignosVitales(signos);
		
		when(pacienteRepository.findById(1)).thenReturn(Optional.of(paciente));
		pacienteService.obtenerPacientePorId(1);		
	}
	
	@Test
	void test_obtenerPacientePorNombreNull() {
		pacienteService.obtenerPacientePorNombre("diego");
		verify(pacienteRepository).findByNombreCompleto("diego");
	}
	
	@Test
	void test_obtenerPacientePorNombreNullNotNull() {
		Paciente paciente = new Paciente();
		List<SignoVital> signos = Arrays.asList(new SignoVital(),new SignoVital());
		paciente.setSignosVitales(signos);
		
		when(pacienteRepository.findByNombreCompleto("diego")).thenReturn(paciente);
		pacienteService.obtenerPacientePorNombre("diego");	
	}
	
	@Disabled
	void test_agregarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNombreCompleto("diego");
		List<SignoVital> signos = Arrays.asList(new SignoVital(),new SignoVital());
		paciente.setSignosVitales(signos);
		
		when(pacienteRepository.save(paciente)).thenReturn(paciente);		
		pacienteService.agregarPaciente(paciente);
	}
	
	@Test
	void test_agregarListaPacientes() {
		List<SignoVital> signos = Arrays.asList(new SignoVital(),new SignoVital());
		Paciente paciente1 = new Paciente();
		paciente1.setId(1);		
		paciente1.setSignosVitales(signos);
		Paciente paciente2 = new Paciente("diego",new Date(),signos);
		paciente2.setId(2);
		List<Paciente> pacientes = Arrays.asList(paciente1,paciente2);
		
		pacienteService.agregarListaPacientes(pacientes);
	}
	
	@Test
	void test_agregarSignoVitalNotNull() {		
		Paciente paciente = new Paciente();
		paciente.setId(1);
		SignoVital signo =new SignoVital();		
		when(pacienteRepository.findById(1)).thenReturn(Optional.of(paciente));
		when(pacienteRepository.save(paciente)).thenReturn(paciente);
		pacienteService.agregarSignoVital(1, signo);		
	}
	
	@Test
	void test_agregarSignoVitalNull() {
		pacienteService.agregarSignoVital(1, null);		
	}
	
	@Disabled
	void test_actualizarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setId(1);
		paciente.setNombreCompleto("diego");
		paciente.setFechaNacimiento(new Date());
		List<SignoVital> signos = Arrays.asList(new SignoVital(),new SignoVital());
		paciente.setSignosVitales(signos);
		
		Mockito.when(pacienteRepository.findById(1)).thenReturn(Optional.of(paciente));	
		//when(pacienteServiceMock.actualizarPaciente(1, paciente)).thenReturn(new PacienteDTO(paciente));
		pacienteService.actualizarPaciente(1, paciente);	
		
	}
	
	@Test
	void test_borrarPacienteTrue() {		
		Mockito.when(pacienteRepository.existsById(1)).thenReturn(true);
		boolean result = pacienteService.borrarPaciente(1);
		assertEquals(true, result);
	}
	@Test
	void test_borrarPacienteFalse() {		
		Mockito.when(pacienteRepository.existsById(1)).thenReturn(false);
		boolean result = pacienteService.borrarPaciente(1);
		assertEquals(false, result);
	}

}
