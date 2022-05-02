package com.proyecto.apiatencionmedica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.reponseDTO.RoleDTO;
import com.proyecto.apiatencionmedica.reponseDTO.UserDTO;
import com.proyecto.apiatencionmedica.repositories.RoleRepository;
import com.proyecto.apiatencionmedica.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	private RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<UserDTO> getUsers() {
		return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	public RoleDTO saveRole(Role role) {
		return new RoleDTO(roleRepository.save(role));
	}

	public UserDTO saveUser(User user) {
		if (user.getRoles() == null)
			user.setRoles(new ArrayList<Role>());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new UserDTO(userRepository.save(user));
	}

	public UserDTO addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username).orElse(null);
		Role role = roleRepository.findByAuthority(roleName).orElse(null);

		if (user == null || role == null)
			return null;

		if (role.getUsername() != null)
			role = roleRepository.save(new Role(roleName));

		role.setUsername(user);
		user = userRepository.save(user);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	public boolean deleteUser(String username) {
		if (userRepository.findById(username).isEmpty())
			return false;
		userRepository.deleteById(username);
		return true;
	}

}
