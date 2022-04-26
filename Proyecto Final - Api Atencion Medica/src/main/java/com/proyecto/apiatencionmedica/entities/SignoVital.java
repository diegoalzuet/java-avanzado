package com.proyecto.apiatencionmedica.entities;

import javax.persistence.*;

import com.proyecto.apiatencionmedica.generic.entity.GenericEntity;

@Entity
@Table(name = "signos_vitales")
public class SignoVital implements GenericEntity<SignoVital, Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "signo_vital")
    private String nombreSV;

    @Column(name = "valor")
    private double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public SignoVital() {
    }

    public SignoVital(String nombreSV, double valor, Paciente paciente) {
        this.nombreSV = nombreSV;
        this.valor = valor;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombreSV() {
        return nombreSV;
    }

    public void setNombreSV(String nombreSV) {
        this.nombreSV = nombreSV;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "SignoVital{" +
                "id=" + id +
                ", nombreSV='" + nombreSV + '\'' +
                ", valor=" + valor +
                ", paciente=" + paciente +
                '}';
    }
}
