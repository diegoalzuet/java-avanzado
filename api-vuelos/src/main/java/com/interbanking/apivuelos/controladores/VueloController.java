package com.interbanking.apivuelos.controladores;

import com.interbanking.apivuelos.controladores.respuestaDTO.VueloDTO;
import com.interbanking.apivuelos.entidades.VueloEntity;
import com.interbanking.apivuelos.servicios.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("apiVuelos/v1")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/vuelos")
    List<VueloDTO> obtenerVuelos(){
        return StreamSupport.stream( vueloService.obtenerVuelos().spliterator(),false)
                .map(VueloDTO::new)
                .collect(Collectors.toList());
    }
    @PostMapping("/agregarVuelo")
    VueloEntity agregarVuelo(@RequestBody VueloEntity vuelo){
        return vueloService.agregarVuelo(vuelo);
    }
    @GetMapping("/vuelos/{id}")
    VueloEntity obtenerVuelo(@PathVariable Long id){
        return vueloService.obtenerUnVueloPorId(id);
    }
    @PutMapping("/vuelos/{id}")
    VueloEntity actualizarVuelo(@PathVariable Long id, @RequestBody VueloEntity vueloNuevo){
        return vueloService.actualizarVueloPorId(id,vueloNuevo);
    }
    @DeleteMapping("/vuelos/{id}")
    void borrarVuelo(@PathVariable Long id){
        vueloService.borrarVuelo(id);
    }
}
