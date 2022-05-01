package com.proyecto.apiatencionmedica.reponseDTO;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.apiatencionmedica.entities.User;

public class UserDTO {
	
	private String username;
	private Boolean activo;
	private List<RoleDTO> roles; 
	
	public UserDTO(User user) {
		this.username = user.getUsername();
		this.activo = user.getActivo();
		this.roles = new ArrayList<>();
		user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	

}
