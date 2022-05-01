package com.proyecto.apiatencionmedica.entities;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User username;

    @Column(name = "authority")
    private String authority;

    public Role() {
    }

    public Role(String role){
        this.username = null;
        this.authority = role;
    }
    public Role(User username, String role) {
        this.username = username;
        this.authority = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getRole() {
        return authority;
    }

    public void setRol(String role) {
        this.authority = role;
    }
}
