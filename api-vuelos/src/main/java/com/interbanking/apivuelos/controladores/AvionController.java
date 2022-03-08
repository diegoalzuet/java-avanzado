package com.interbanking.apivuelos.controladores;

import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.servicios.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiVuelos/v1")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping("/aviones")
    Iterable<AvionEntity> obtenerAviones(){
        return avionService.obtenerAviones();
    }

    @PostMapping("/agregarAvion")
    AvionEntity agregarAvion(@RequestBody AvionEntity avion){
        return avionService.agregarAvion(avion);
    }

    @GetMapping("/aviones/{id}")
    AvionEntity obtenerAvion(@PathVariable Long id){
        return avionService.obtenerUnAvionPorId(id);
    }
    @PutMapping("/aviones/{id}")
    AvionEntity actualizarAvion(@PathVariable Long id, @RequestBody AvionEntity avionNuevo){
        return avionService.actualizarAvion(id,avionNuevo);
    }

    @DeleteMapping("/aviones/{id}")
    void borrarAvion(@PathVariable Long id){
        avionService.borrarAvion(id);
    }
}
