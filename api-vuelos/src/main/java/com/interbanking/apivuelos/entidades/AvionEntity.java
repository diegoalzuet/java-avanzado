package com.interbanking.apivuelos.entidades;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "avion")
public class AvionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="avion_id")
    private Long id;

    @Column(name="cantidad_asientos")
    private Integer cantidadAsientos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "avion")
    private List<VueloEntity> vuelos;

    public AvionEntity() {
    }

    public AvionEntity(Integer cantidadAsientos, List<VueloEntity> vuelos) {
        this.cantidadAsientos = cantidadAsientos;
        this.vuelos = vuelos;
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

    public List<VueloEntity> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloEntity> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public String toString() {
        return "AvionEntity{" +
                "id=" + id +
                ", cantidadAsientos=" + cantidadAsientos +
                '}';
    }
}
