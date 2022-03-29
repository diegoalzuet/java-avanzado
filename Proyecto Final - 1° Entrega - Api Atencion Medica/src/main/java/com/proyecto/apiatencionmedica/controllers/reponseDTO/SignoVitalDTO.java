package com.proyecto.apiatencionmedica.controllers.reponseDTO;


import com.proyecto.apiatencionmedica.entities.SignoVital;

public class SignoVitalDTO {

    private Integer id;
    private String nombreSV;
    private Double valor;

    public SignoVitalDTO() {
    }
    public SignoVitalDTO(SignoVital signoVital){
        this.id = signoVital.getId();
        this.nombreSV = signoVital.getNombreSV();
        this.valor= signoVital.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSV() {
        return nombreSV;
    }

    public void setNombreSV(String nombreSV) {
        this.nombreSV = nombreSV;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
