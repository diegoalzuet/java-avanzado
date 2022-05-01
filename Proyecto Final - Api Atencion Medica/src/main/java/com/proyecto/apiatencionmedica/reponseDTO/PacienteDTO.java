package com.proyecto.apiatencionmedica.reponseDTO;

import com.proyecto.apiatencionmedica.entities.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDTO {

    private Integer id;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private List<SignoVitalDTO> signosVitalesDTO;

    public PacienteDTO() {
    }
    public PacienteDTO(Paciente paciente){
        this.id = paciente.getId();
        this.nombreCompleto = paciente.getNombreCompleto();
        this.fechaNacimiento = paciente.getFechaNacimiento();
        this.signosVitalesDTO = new ArrayList<>();
        paciente.getSignosVitales().forEach(signoVital -> this.signosVitalesDTO.add(new SignoVitalDTO(signoVital)));
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

    public List<SignoVitalDTO> getSignosVitales() {
        return signosVitalesDTO;
    }

    public void setSignosVitales(List<SignoVitalDTO> signosVitales) {
        this.signosVitalesDTO = signosVitales;
    }
}
