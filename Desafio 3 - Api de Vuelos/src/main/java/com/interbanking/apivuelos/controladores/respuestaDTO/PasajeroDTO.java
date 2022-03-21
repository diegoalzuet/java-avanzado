package com.interbanking.apivuelos.controladores.respuestaDTO;

import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.entidades.VueloEntity;
import java.util.List;

public class PasajeroDTO {

    private Long id;
    private String nombreCompleto;
    private String dni;
    private List<VueloEntity> vuelos;

    public PasajeroDTO(){

    }
    public PasajeroDTO(PasajeroEntity pasajero){
        this.id = pasajero.getId();
        this.nombreCompleto = pasajero.getNombreCompleto();
        this.dni = pasajero.getDni();
        this.vuelos = pasajero.getVuelos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
