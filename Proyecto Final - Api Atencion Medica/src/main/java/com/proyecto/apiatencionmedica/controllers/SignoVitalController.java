package com.proyecto.apiatencionmedica.controllers;

import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.reponseDTO.SignoVitalDTO;
import com.proyecto.apiatencionmedica.services.SignoVitalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signosVitales")
@Tag(name = "Signos Vitales", description = "API de Signos Vitales del Paciente")
public class SignoVitalController {

	@Autowired
	private SignoVitalService signoVitalService;

	// MUESTRA TODOS LOS SIGNOS VITALES REGISTRADOS DE TODOS LOS USUARIOS
	@Operation(summary = "Listar todos los signos vitales", description = "Servicio para obtener el listado de todos los signos vitales.")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_NURSE')")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<SignoVitalDTO> listarSignosVitales() {
		return signoVitalService.listarSignosVitales();
	}

	// MUESTRA LOS SIGNOS VITALES DE UN PACIENTE SOLICITADO
	@Operation(summary = "Listar todos los signos vitales de un paciente especificado", description = "Servicio para obtener el listado de todos los signos vitales de un paciente especificado.")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_NURSE')")
	@GetMapping("/paciente")
	@ResponseStatus(code = HttpStatus.OK)
	List<SignoVitalDTO> listarSignosVitalesPorPaciente(@RequestBody Paciente paciente) {
		return signoVitalService.listarSignosVitalesPorPaciente(paciente);
	}

	// ACTUALIZA UN SIGNO VITAL Y DEVUELVE LA LISTA DE LOS SIGNOS VITALES DE ESE
	// PACIENTE
	@Operation(summary = "Actualizar un signo vital", description = "Servicio para actualizar un signo vital de un paciente.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Signo vital actualizado satisfactoriamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SignoVitalDTO.class))),
			@ApiResponse(responseCode = "404", description = "No se encontro el signo vital especificado especificado", content = @Content(mediaType = "application/json")) })
	@PreAuthorize("hasAuthority('SCOPE_ROLE_NURSE')")
	@PutMapping("/paciente/{idSignoVital}")
	ResponseEntity<List<SignoVitalDTO>> actualizarSignosVitales(@RequestBody SignoVital signoVital,
			@PathVariable Integer idSignoVital) {
		List<SignoVitalDTO> signos = signoVitalService.actualizarSignosVitales(signoVital, idSignoVital);
		return (signos != null) ? ResponseEntity.status(HttpStatus.CREATED).body(signos)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// ELIMINA UN SIGNO VITAL DE UN PACIENTE
	@Operation(summary = "Borrar un signo vital", description = "Servicio para borrar un signo vital de un paciente.")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_DOCTOR')")
	@DeleteMapping("/paciente/{idSignoVital}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void eliminarSignoVital(@PathVariable Integer idSignoVital) {
		signoVitalService.eliminarSignoVital(idSignoVital);
	}
}
