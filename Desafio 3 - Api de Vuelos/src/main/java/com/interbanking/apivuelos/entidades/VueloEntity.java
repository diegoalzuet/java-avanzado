package com.interbanking.apivuelos.entidades;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class VueloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vuelo_id")
    private Long id;

    @Column(name= "fecha_hora_partida")
    private Date fechaHoraPartida;

    @Column(name= "fecha_hora_arribo")
    private Date fechaHoraArribo;

    @Column(name="origen")
    private String origen;

    @Column(name="destino")
    private String destino;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pasajeros_vuelos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "pasajero_id"))
    private List<PasajeroEntity> pasajeros;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "avion_id")
    private AvionEntity avion;

    public VueloEntity() {
    }

    public VueloEntity(Date fechaHoraPartida, Date fechaHoraArribo, String origen, String destino, List<PasajeroEntity> pasajeros, AvionEntity avion) {

        this.fechaHoraPartida = fechaHoraPartida;
        this.fechaHoraArribo = fechaHoraArribo;
        this.origen = origen;
        this.destino = destino;
        this.pasajeros = pasajeros;
        this.avion = avion;
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


    public List<PasajeroEntity> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<PasajeroEntity> pasajeros) {
        this.pasajeros = pasajeros;
    }


    public AvionEntity getAvion() {
        return avion;
    }

    public void setAvion(AvionEntity avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "VueloEntity{" +
                "id=" + id +
                ", fechaHoraPartida=" + fechaHoraPartida +
                ", fechaHoraArribo=" + fechaHoraArribo +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", avion=" + avion +
                '}';
    }
}
