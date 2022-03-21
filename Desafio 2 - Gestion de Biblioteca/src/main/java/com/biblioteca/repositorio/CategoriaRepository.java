package com.biblioteca.repositorio;

import com.biblioteca.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
}
