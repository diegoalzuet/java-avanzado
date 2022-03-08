package com.interbanking.apivuelos.controladores;

import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.servicios.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiVuelos/v1")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping("/pasajeros")
    Iterable<PasajeroEntity> obtenerPasajeros(){
        return pasajeroService.obtenerPasajeros();
    }
    @PostMapping("/agregarPasajero")
    PasajeroEntity agregarPasajero(@RequestBody PasajeroEntity pasajero){
        return pasajeroService.agregarPasajero(pasajero);
    }
    @GetMapping("/pasajeros/{id}")
    PasajeroEntity obtenerPasajeroPorId(@PathVariable Long id){
        return pasajeroService.obtenerPasajeroPorId(id);
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
