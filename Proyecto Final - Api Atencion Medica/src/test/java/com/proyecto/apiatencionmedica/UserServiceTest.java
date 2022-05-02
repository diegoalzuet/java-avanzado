package com.proyecto.apiatencionmedica;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.reponseDTO.RoleDTO;
import com.proyecto.apiatencionmedica.reponseDTO.UserDTO;
import com.proyecto.apiatencionmedica.repositories.RoleRepository;
import com.proyecto.apiatencionmedica.repositories.UserRepository;
import com.proyecto.apiatencionmedica.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	@Mock
	RoleRepository roleRepository;
	@Mock
	PasswordEncoder passwordEncoder;
	
	private UserService userService;
	
	@BeforeEach
	void setup() {
		userService = new UserService(userRepository,roleRepository,passwordEncoder);
	}
	
	@Test
	void test_getUsers() {
		userService.getUsers();		
	}
	@Test
	void test_saveRole() {
		Role role = new Role("test");		
		Mockito.when(roleRepository.save(role)).thenReturn(role);
		RoleDTO dto = userService.saveRole(role);
		assertEquals("test",dto.getRole());		
	}
	
	@Test
	void test_saveUserRoleNull() {
		User user = new User();	
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserDTO dto = userService.saveUser(user);		
		assertNotNull(dto);
	}
	@Test
	void test_saveUserRoleNotNull() {
		User user = new User();	
		Role role = new Role("test");
		user.setRoles(Arrays.asList(role));
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserDTO dto = userService.saveUser(user);		
		assertNotNull(dto);
	}
	
	@Test
	void test_addRoleToUserOk() {
		User user = new User();
		Role role = new Role("test");
		String username = "test";
		String roleName = "test";
		user.setUsername(username);
		user.setRoles(Arrays.asList(role));
		Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
		Mockito.when(roleRepository.findByAuthority(username)).thenReturn(Optional.of(role));
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserDTO dto = userService.addRoleToUser(username, roleName);
		assertEquals("test", dto.getUsername());
	}
	@Test
	void test_addRoleToUserRoleUsernameNotNull() {
		User user = new User();
		Role role = new Role("test");
		String username = "test";
		String roleName = "test";
		user.setUsername(username);
		user.setRoles(Arrays.asList(role));
		role.setUsername(user);
		Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
		Mockito.when(roleRepository.findByAuthority(username)).thenReturn(Optional.of(role));
		Mockito.when(roleRepository.save(any(Role.class))).thenReturn(role);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserDTO dto = userService.addRoleToUser(username, roleName);
		assertEquals("test", dto.getUsername());
	}
	
	@Test
	void test_addRoleToUserUserNull() {
		User user = new User();
		Role role = new Role("test");
		String username = "test";
		String roleName = "test";
		user.setUsername(username);
		user.setRoles(Arrays.asList(role));
		Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());		
		assertNull(userService.addRoleToUser(username, roleName));
	}
	
	@Test
	void test_addRoleToUserRoleNull() {
		User user = new User();
		Role role = new Role("test");
		String username = "test";
		String roleName = "test";
		user.setUsername(username);
		user.setRoles(Arrays.asList(role));
		Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
		Mockito.when(roleRepository.findByAuthority(username)).thenReturn(Optional.empty());
		assertNull(userService.addRoleToUser(username, roleName));
	}
	
	@Test
	void test_deleteUserOk() {
		User user = new User();
		String username = "test";
		Mockito.when(userRepository.findById(username)).thenReturn(Optional.of(user));
		doNothing().when(userRepository).deleteById(username);
		boolean result = userService.deleteUser(username);
		assertEquals(true, result);
	}
	@Test
	void test_deleteUserNotFound() {
		String username = "test";
		Mockito.when(userRepository.findById(username)).thenReturn(Optional.empty());
		boolean result = userService.deleteUser(username);
		assertEquals(false, result);
	}

}
