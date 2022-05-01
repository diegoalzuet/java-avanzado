package com.proyecto.apiatencionmedica.services;

import com.proyecto.apiatencionmedica.entities.Paciente;
import com.proyecto.apiatencionmedica.entities.SignoVital;
import com.proyecto.apiatencionmedica.reponseDTO.SignoVitalDTO;
import com.proyecto.apiatencionmedica.repositories.SignoVitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignoVitalService {

    @Autowired
    private SignoVitalRepository signoVitalRepository;

    public List<SignoVitalDTO> listarSignosVitales(){
        return  signoVitalRepository.findAll()
                .stream()
                .map(SignoVitalDTO::new)
                .collect(Collectors.toList());
    }

    public List<SignoVitalDTO> listarSignosVitalesPorPaciente( Paciente paciente){
        return  signoVitalRepository.findByPaciente(paciente)
                .stream()
                .map(SignoVitalDTO::new)
                .collect(Collectors.toList());
    }

    public List<SignoVitalDTO> actualizarSignosVitales( SignoVital signoVital,  Integer idSignoVital){
        SignoVital sv = signoVitalRepository.findById(idSignoVital).orElse(null);
        if(sv!=null){
            sv.setNombreSV(signoVital.getNombreSV());
            sv.setValor(signoVital.getValor());
            sv = signoVitalRepository.save(sv);
            return sv.getPaciente().getSignosVitales().stream().map(SignoVitalDTO::new).collect(Collectors.toList());
        }
        return null;
    }

    public void eliminarSignoVital( Integer idSignoVital){
        SignoVital sv = signoVitalRepository.findById(idSignoVital).orElse(null);
        if(sv!=null)
            signoVitalRepository.deleteById(idSignoVital);
    }
}
