package com.peliculas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculasService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS pelicula_actor");
        jdbcTemplate.execute("DROP TABLE IF EXISTS peliculas");
        jdbcTemplate.execute("DROP TABLE IF EXISTS categorias ");
        jdbcTemplate.execute("DROP TABLE IF EXISTS actores");

        String queryPeliculas = "CREATE TABLE peliculas(id serial NOT NULL, nombre varchar NULL, presupuesto INTEGER NULL, " +
                " fecha_estreno DATE, categoria_id Integer, CONSTRAINT pelicula_pkey PRIMARY KEY(id), FOREIGN KEY (categoria_id) REFERENCES categorias(id))";

        String queryCategoria = "CREATE TABLE categorias(id serial NOT NULL, categoria varchar NULL, CONSTRAINT categorias_pkey PRIMARY KEY(id))";
        String queryActor = "CREATE TABLE actores(id serial NOT NULL, nombre varchar NULL, fecha_nacimiento DATE NULL, CONSTRAINT actores_pkey PRIMARY KEY(id))";

        String queryPeliculaActor = "CREATE TABLE pelicula_actor ( id_pelicula INTEGER NOT NULL, id_actor INTEGER NOT NULL, sueldo float8 NOT NULL, " +
                "PRIMARY KEY(id_pelicula,id_actor), FOREIGN KEY(id_pelicula) REFERENCES peliculas(id), FOREIGN KEY(id_actor) REFERENCES actores(id))";

        //CREAMOS LAS TABLAS
        jdbcTemplate.execute(queryCategoria);
        jdbcTemplate.execute(queryPeliculas);
        jdbcTemplate.execute(queryActor);
        jdbcTemplate.execute(queryPeliculaActor);

        // INSERTAMOS CATEGORIAS
        String insertarCategoria1=" INSERT INTO categorias VALUES(1,'Accion')";
        String insertarCategoria2=" INSERT INTO categorias VALUES(2,'Ciencia Ficcion')";
        String insertarCategoria3=" INSERT INTO categorias VALUES(3,'Drama')";
        jdbcTemplate.execute(insertarCategoria1);
        jdbcTemplate.execute(insertarCategoria2);
        jdbcTemplate.execute(insertarCategoria3);

        // INSERTAMOS PELICULAS
        String insertarPelicula1=" INSERT INTO peliculas VALUES(1,'El secreto de sus ojos', 250000,'2009-8-13',3 )";
        String insertarPelicula2=" INSERT INTO peliculas VALUES(2,'Batman: El caballero de la noche', 370000,'2008-06-17' ,1)";
        String insertarPelicula3=" INSERT INTO peliculas VALUES(3,'Spiderman: No way home', 480000,'2021-12-16',2 )";
        jdbcTemplate.execute(insertarPelicula1);
        jdbcTemplate.execute(insertarPelicula2);
        jdbcTemplate.execute(insertarPelicula3);

        // INSERTAMOS ACTORES
        String insertarActor1=" INSERT INTO actores VALUES(1,'Christian Bale','1974-01-30')";
        String insertarActor2=" INSERT INTO actores VALUES(2,'Tobey Maguire','1975-05-27')";
        String insertarActor3=" INSERT INTO actores VALUES(3,'Ricardo Darin','1957-01-16')";
        jdbcTemplate.execute(insertarActor1);
        jdbcTemplate.execute(insertarActor2);
        jdbcTemplate.execute(insertarActor3);

        // INSERTAMOS RELACION PELICULA-ACTOR
        String insertarPeliculaActor1=" INSERT INTO pelicula_actor VALUES(2,1,150000)";
        String insertarPeliculaActor2=" INSERT INTO pelicula_actor VALUES(1,3,2321556)";
        String insertarPeliculaActor3=" INSERT INTO pelicula_actor VALUES(3,2,800000)";
        jdbcTemplate.execute(insertarPeliculaActor1);
        jdbcTemplate.execute(insertarPeliculaActor2);
        jdbcTemplate.execute(insertarPeliculaActor3);
    }

    public List<String> mostrarPeliculasDetalle(){
        String query = "SELECT p.nombre as pelicula,c.categoria as categoria, a.nombre as actor,pa.sueldo as sueldo " +
                "FROM pelicula_actor pa,peliculas p,actores a , categorias c " +
                "WHERE p.id=pa.id_pelicula and a.id = id_actor and p.categoria_id=c.id";

        List<String> peliculas = new ArrayList<>();
        jdbcTemplate
                .query(
                        query,
                        new Object[] {},
                        (rs, row) ->
                                "Titulo: " + rs.getString("pelicula") +
                                ", Genero: "+ rs.getString("categoria") +
                                ", Actor: " + rs.getString("actor")  +
                                ", Sueldo: "+ rs.getString("sueldo"))
                .forEach(pelicula -> peliculas.add(pelicula));
        return peliculas;
    }
}
