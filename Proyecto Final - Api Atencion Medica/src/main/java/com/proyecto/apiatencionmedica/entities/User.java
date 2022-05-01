package com.proyecto.apiatencionmedica.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "username", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Role> roles;
    
    @OneToOne(cascade=CascadeType.REMOVE, optional=true)
    private Paciente paciente;

    public User() {
    }

    public User(String username, String password, Boolean activo, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = activo;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return enabled;
    }

    public void setActivo(Boolean activo) {
        this.enabled = activo;
    }

    public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
