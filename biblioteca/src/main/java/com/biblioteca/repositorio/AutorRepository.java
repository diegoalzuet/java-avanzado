package com.biblioteca.repositorio;

import com.biblioteca.entidades.Autor;
import com.biblioteca.entidades.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepository extends CrudRepository<Autor,Long> {
}
