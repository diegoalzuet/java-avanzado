package com.biblioteca.servicios;

import com.biblioteca.entidades.Categoria;
import com.biblioteca.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Iterable<Categoria> getCategorias(){return categoriaRepository.findAll();}
    public void guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
