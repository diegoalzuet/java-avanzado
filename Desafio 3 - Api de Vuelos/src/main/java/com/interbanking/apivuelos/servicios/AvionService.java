package com.interbanking.apivuelos.servicios;

import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.excepciones.AvionNotFoundException;
import com.interbanking.apivuelos.repositorio.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public Iterable<AvionEntity> obtenerAviones(){
        return avionRepository.findAll();
    }
    public AvionEntity agregarAvion(AvionEntity avion){
        return avionRepository.save(avion);
    }
    public AvionEntity obtenerUnAvionPorId(Long id){
        return avionRepository.findById(id).orElseThrow(() -> new AvionNotFoundException(id));
    }
    public AvionEntity actualizarAvion(Long id, AvionEntity avionNuevo){
        return avionRepository.findById(id).map(avion ->{
            avion.setCantidadAsientos(avionNuevo.getCantidadAsientos());
            avion.setVuelos(avionNuevo.getVuelos());
            return avionRepository.save(avion);
        } ).orElseGet(() -> {
            return avionRepository.save(avionNuevo);
        });
    }

    public void borrarAvion(Long id){
        avionRepository.deleteById(id);
    }
}
