package com.interbanking.apivuelos.controladores;

import com.interbanking.apivuelos.controladores.respuestaDTO.PasajeroDTO;
import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.servicios.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("apiVuelos/v1")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping("/pasajeros")
    List<PasajeroDTO> obtenerPasajeros(){
        return StreamSupport.stream(pasajeroService.obtenerPasajeros().spliterator(),false)
                .map(PasajeroDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/pasajeros/{id}")
    PasajeroDTO obtenerPasajeroPorId(@PathVariable Long id){
        return new PasajeroDTO(pasajeroService.obtenerPasajeroPorId(id));
    }

    @PostMapping("/agregarPasajero")
    PasajeroEntity agregarPasajero(@RequestBody PasajeroEntity pasajero){
        return pasajeroService.agregarPasajero(pasajero);
    }

    @PutMapping("/pasajeros/{id}")
    PasajeroEntity actualizarPasajero(@PathVariable Long id, @RequestBody PasajeroEntity pasajeroNuevo){
        return pasajeroService.actualizarPasajero(id,pasajeroNuevo);
    }

    @DeleteMapping("/pasajeros/{id}")
    void borrarPasajero(@PathVariable Long id){
        pasajeroService.borrarPasajero(id);
    }

}
