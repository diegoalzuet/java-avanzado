package com.proyecto.apiatencionmedica.reponseDTO;

import com.proyecto.apiatencionmedica.entities.Role;

public class RoleDTO {
	
	private String role;
	
	public RoleDTO(Role role) {
		this.role = role.getRole();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
