package com.interbanking.apivuelos.controladores.respuestaDTO;
import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.entidades.VueloEntity;
import java.util.Date;
import java.util.List;

public class VueloDTO {

    private Long id;
    private Date fechaHoraPartida;
    private Date fechaHoraArribo;
    private String origen;
    private String destino;
    private List<PasajeroEntity> pasajeros;
    private AvionEntity avion;

    public VueloDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHoraPartida() {
        return fechaHoraPartida;
    }

    public void setFechaHoraPartida(Date fechaHoraPartida) {
        this.fechaHoraPartida = fechaHoraPartida;
    }

    public Date getFechaHoraArribo() {
        return fechaHoraArribo;
    }

    public void setFechaHoraArribo(Date fechaHoraArribo) {
        this.fechaHoraArribo = fechaHoraArribo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public VueloDTO(VueloEntity vuelo){
        this.id = vuelo.getId();
        this.fechaHoraArribo = vuelo.getFechaHoraArribo();
        this.fechaHoraPartida = vuelo.getFechaHoraPartida();
        this.destino = vuelo.getDestino();
        this.origen = vuelo.getOrigen();
        this.pasajeros = vuelo.getPasajeros();
        this.avion = vuelo.getAvion();
    }
}
