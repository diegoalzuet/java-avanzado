package com.biblioteca.servicios;

import com.biblioteca.entidades.Autor;
import com.biblioteca.repositorio.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Iterable<Autor> getAutores(){return  autorRepository.findAll();}

    public void guardarAutor(Autor autor){
        autorRepository.save(autor);
    }

    public Autor getAutor(Long id){
       return autorRepository.findById(id).orElse(null);
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);
    }

    public void updateAutor(Long id,Autor autor){
        Autor autorActualizar = autorRepository.findById(id).orElse(null);
        autorActualizar.setFechaNacimiento(autor.getFechaNacimiento());
        autorActualizar.setNombre(autor.getNombre());
        autorActualizar.setNacionalidad((autor.getNacionalidad()));
        autorRepository.save(autorActualizar);
    }
}
