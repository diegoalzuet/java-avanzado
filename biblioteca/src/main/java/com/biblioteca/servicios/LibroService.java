package com.biblioteca.servicios;

import com.biblioteca.entidades.Libro;
import com.biblioteca.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Iterable<Libro> getLibros(){return libroRepository.findAll();    }

    public void guardarLibro(Libro libro){
        libroRepository.save(libro);
    }
}
