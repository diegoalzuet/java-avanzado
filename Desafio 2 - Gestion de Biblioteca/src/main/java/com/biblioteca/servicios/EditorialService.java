package com.biblioteca.servicios;

import com.biblioteca.entidades.Editorial;
import com.biblioteca.repositorio.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public Iterable<Editorial> getEditoriales(){return editorialRepository.findAll();}
    public void guardarEditorial(Editorial editorial){
        editorialRepository.save(editorial);
    }
}
