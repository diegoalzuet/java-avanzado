package com.proyecto.apiatencionmedica.entities;

import javax.persistence.*;

import com.proyecto.apiatencionmedica.generic.entity.GenericEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente implements GenericEntity<Paciente, Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<SignoVital> signosVitales;

    public Paciente() {
    }

    public Paciente(String nombreCompleto, Date fechaNacimiento, List<SignoVital> signosVitales) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.signosVitales = signosVitales;
    }
    public void addSignoVital(SignoVital signoVital){
        if (this.signosVitales==null)
            this.signosVitales=new ArrayList<>();

        this.signosVitales.add(signoVital);
        signoVital.setPaciente(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<SignoVital> getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(List<SignoVital> signosVitales) {
        this.signosVitales = signosVitales;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
