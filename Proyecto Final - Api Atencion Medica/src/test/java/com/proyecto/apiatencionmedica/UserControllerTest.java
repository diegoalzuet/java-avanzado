package com.proyecto.apiatencionmedica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyecto.apiatencionmedica.controllers.UserController;
import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.reponseDTO.RoleDTO;
import com.proyecto.apiatencionmedica.reponseDTO.UserDTO;
import com.proyecto.apiatencionmedica.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Test
	void test_getUsersOk() {
		Mockito.when(userService.getUsers()).thenReturn(new ArrayList<>());
		ResponseEntity<?> rs = userController.getUsers();
		assertEquals(HttpStatus.OK, rs.getStatusCode());
	}
	
	@Test
	void test_saveUserCreated() {
		User user = new User();
		Mockito.when(userService.saveUser(user)).thenReturn(any(UserDTO.class));
		ResponseEntity<?> rs = userController.saveUser(user);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	@Test
	void test_saveRoleCreated() {
		Role role = new Role();
		Mockito.when(userService.saveRole(role)).thenReturn(any(RoleDTO.class));
		ResponseEntity<?> rs = userController.saveRole(role);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	
	@Test
	void test_setRoleCreated() {
		UserDTO dto = new UserDTO(new User("diego", "", true, Arrays.asList(new Role("role"))));
		String username = "username";
		String role = "role";
		Mockito.when(userService.addRoleToUser(eq(username),any())).thenReturn(dto);
		ResponseEntity<?> rs = userController.setRole(username, role);
		assertEquals(HttpStatus.CREATED, rs.getStatusCode());
	}
	@Test
	void test_setRoleNotFound() {
		Mockito.when(userService.addRoleToUser("username", "role")).thenReturn(null);
		ResponseEntity<?> rs = userController.setRole("username", "role");
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	
	@Test
	void test_deleteUserNoContent() {
		String username = "diego";
		Mockito.when(userService.deleteUser(username)).thenReturn(true);
		ResponseEntity<?> rs = userController.deleteUser(username);
		assertEquals(HttpStatus.NO_CONTENT, rs.getStatusCode());
	}
	@Test
	void test_deleteUserNotFound() {
		String username = "diego";
		Mockito.when(userService.deleteUser(username)).thenReturn(false);
		ResponseEntity<?> rs = userController.deleteUser(username);
		assertEquals(HttpStatus.NOT_FOUND, rs.getStatusCode());
	}
	
	
}
