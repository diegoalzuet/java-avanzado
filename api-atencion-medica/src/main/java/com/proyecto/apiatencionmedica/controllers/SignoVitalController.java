package com.proyecto.apiatencionmedica.controllers;

import com.proyecto.apiatencionmedica.controllers.reponseDTO.SignoVitalDTO;
import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.repositories.SignoVitalRepository;
import com.proyecto.apiatencionmedica.services.SignoVitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signosVitales")
public class SignoVitalController {

    @Autowired
    private SignoVitalService signoVitalService;

    //MUESTRA TODOS LOS SIGNOS VITALES REGISTRADOS DE TODOS LOS USUARIOS
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping
    List<SignoVitalDTO> listarSignosVitales(){
        return  signoVitalService.listarSignosVitales();
    }

    //MUESTRA LOS SIGNOS VITALES DE UN PACIENTE SOLICITADO
    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/paciente")
    List<SignoVitalDTO> listarSignosVitalesPorPaciente(@RequestBody Paciente paciente){
        return  signoVitalService.listarSignosVitalesPorPaciente(paciente);
    }

    //ACTUALIZA UN SIGNO VITAL Y DEVUELVE LA LISTA DE LOS SIGNOS VITALES DE ESE PACIENTE
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/paciente/actualizarSignosVitales/{idSignoVital}")
    List<SignoVitalDTO> actualizarSignosVitales(@RequestBody SignoVital signoVital, @PathVariable Integer idSignoVital){
        return signoVitalService.actualizarSignosVitales(signoVital,idSignoVital);
    }

    //ELIMINA UN SIGNO VITAL DE UN PACIENTE
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/paciente/borrarSignoVital/{idSignoVital}")
    void eliminarSignoVital(@PathVariable Integer idSignoVital){
       signoVitalService.eliminarSignoVital(idSignoVital);
    }
}
