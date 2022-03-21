package com.interbanking.apivuelos.entidades;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pasajero")
public class PasajeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pasajero_id")
    private Long id;

    @Column(name ="nombre_completo")
    private String nombreCompleto;

    @Column(name="dni")
    private String dni;

    @ManyToMany(mappedBy = "pasajeros")
    private List<VueloEntity> vuelos;

    public PasajeroEntity() {
    }

    public PasajeroEntity(String nombreCompleto, String dni, List<VueloEntity> vuelos) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.vuelos = vuelos;
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

    public List<VueloEntity> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloEntity> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public String toString() {
        return "PasajeroEntity{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
