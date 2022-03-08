package com.interbanking.apivuelos.controladores.respuestaDTO;

import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.entidades.VueloEntity;

import java.util.List;

public class AvionDTO {

    private Long id;

    private Integer cantidadAsientos;

    private List<VueloEntity> vuelos;

    public AvionDTO() {

    }

    public AvionDTO(AvionEntity avion) {
        this.id = avion.getId();
        this.cantidadAsientos = avion.getCantidadAsientos();
        this.vuelos = avion.getVuelos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

}
