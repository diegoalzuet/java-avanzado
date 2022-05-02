package com.proyecto.apiatencionmedica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.reponseDTO.RoleDTO;
import com.proyecto.apiatencionmedica.reponseDTO.UserDTO;
import com.proyecto.apiatencionmedica.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "API de Usuarios")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Listar todos los usuarios", description = "Servicio para obtener el listado de todos los usuarios.")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<UserDTO>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@Operation(summary = "Agregar un usuario", description = "Servicio para agregar un usuario.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuario agregado satisfactoriamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))) })
	@PostMapping("/user")
	public ResponseEntity<UserDTO> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@Operation(summary = "Agregar un Rol", description = "Servicio para agregar un Rol.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Rol agregado satisfactoriamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleDTO.class))) })
	@PostMapping("/role")
	public ResponseEntity<RoleDTO> saveRole(@RequestBody Role role) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveRole(role));
	}

	@Operation(summary = "Agregar un rol a un usuario", description = "Servicio para asignar un rol a un usuario.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Rol asignado satisfactoriamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),
			@ApiResponse(responseCode = "404", description = "No se encontro el rol o el usuario especificado", content = @Content(mediaType = "application/json")) })
	@PutMapping("/user/rol")
	public ResponseEntity<UserDTO> setRole(@RequestParam String username, @RequestParam String roleName) {
		UserDTO userDTO = userService.addRoleToUser(username, roleName);
		return (userDTO != null ? ResponseEntity.status(HttpStatus.CREATED).body(userDTO) : ResponseEntity.notFound().build());
	}

	@Operation(summary = "Borrar un usuario", description = "Servicio para borrar un usuario.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Usuario eliminado satisfactoriamente", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No se encontro el usuario especificado", content = @Content(mediaType = "application/json")) })
	@DeleteMapping("/user/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) {
		return (userService.deleteUser(username) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.notFound().build());
	}

}
