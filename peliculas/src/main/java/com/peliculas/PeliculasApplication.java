package com.peliculas;

import com.peliculas.services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class PeliculasApplication implements CommandLineRunner {

    @Autowired
    private PeliculasService peliculasService;

    public static void main(String[] args) {
        SpringApplication.run(PeliculasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        peliculasService.insertData();
        List<String> peliculas = peliculasService.mostrarPeliculasDetalle();
        System.out.println("===============================");
        peliculas.forEach(pelicula -> System.out.println(pelicula));
        System.out.println("===============================");

    }

}
