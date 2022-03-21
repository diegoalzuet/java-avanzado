package com.proyecto.apiatencionmedica.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Personal {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "username", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rol> rol;

    public Personal() {
    }

    public Personal(String username, String password, Boolean activo, List<Rol> rol) {
        this.username = username;
        this.password = password;
        this.enabled = activo;
        this.rol = rol;
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

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }
}
