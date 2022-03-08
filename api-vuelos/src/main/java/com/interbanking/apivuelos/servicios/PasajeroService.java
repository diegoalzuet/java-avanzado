package com.interbanking.apivuelos.servicios;

import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.repositorio.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    public Iterable<PasajeroEntity> obtenerPasajeros() {
        return pasajeroRepository.findAll();
    }

    public PasajeroEntity agregarPasajero(PasajeroEntity pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    public PasajeroEntity obtenerPasajeroPorId(Long id) {
        return pasajeroRepository.findById(id).orElse(null);
    }

    public PasajeroEntity actualizarPasajero(Long id, PasajeroEntity pasajeroNuevo) {
        return pasajeroRepository.findById(id)
                .map(pasajero -> {
                    pasajero.setDni(pasajeroNuevo.getDni());
                    pasajero.setNombreCompleto(pasajeroNuevo.getNombreCompleto());
                    pasajero.setVuelos(pasajeroNuevo.getVuelos());
                    return pasajeroRepository.save(pasajero);
                }).orElseGet(() -> {
                    return pasajeroRepository.save(pasajeroNuevo);
                });
    }

    public void borrarPasajero(Long id){
        pasajeroRepository.deleteById(id);
    }
}
