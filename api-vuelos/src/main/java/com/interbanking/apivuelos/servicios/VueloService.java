package com.interbanking.apivuelos.servicios;

import com.interbanking.apivuelos.entidades.VueloEntity;
import com.interbanking.apivuelos.repositorio.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vuelosRepository;

    public Iterable<VueloEntity> obtenerVuelos() {
        return vuelosRepository.findAll();
    }

    public VueloEntity agregarVuelo(VueloEntity vuelo) {
        return vuelosRepository.save(vuelo);
    }

    public VueloEntity obtenerUnVueloPorId(Long id) {
        return vuelosRepository.findById(id).orElse(null);
    }

    public VueloEntity actualizarVueloPorId(Long id, VueloEntity vueloNuevo) {
        return vuelosRepository.findById(id)
                .map(vuelo -> {
                    vuelo.setAvion(vueloNuevo.getAvion());
                    vuelo.setDestino(vueloNuevo.getDestino());
                    vuelo.setFechaHoraArribo(vueloNuevo.getFechaHoraArribo());
                    vuelo.setFechaHoraPartida(vueloNuevo.getFechaHoraPartida());
                    vuelo.setOrigen(vueloNuevo.getOrigen());
                    vuelo.setPasajeros(vueloNuevo.getPasajeros());
                    return vuelosRepository.save(vuelo);
                }).orElseGet(() -> {
                    return vuelosRepository.save(vueloNuevo);
                });
    }

    public void borrarVuelo(Long id){
        vuelosRepository.deleteById(id);
    }
}
