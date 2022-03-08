package com.interbanking.apivuelos.controladores;

import com.interbanking.apivuelos.controladores.respuestaDTO.AvionDTO;
import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.servicios.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("apiVuelos/v1")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping("/aviones")
    List<AvionDTO> obtenerAviones(){
        return StreamSupport.stream(avionService.obtenerAviones().spliterator(),false)
                .map(AvionDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/agregarAvion")
    AvionEntity agregarAvion(@RequestBody AvionEntity avion){
        return avionService.agregarAvion(avion);
    }

    @GetMapping("/aviones/{id}")
    AvionDTO obtenerAvion(@PathVariable Long id){
        return new AvionDTO(avionService.obtenerUnAvionPorId(id));
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
