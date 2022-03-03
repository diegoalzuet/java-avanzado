package com.biblioteca.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="libro")
public class Libro {

    @Id
    @Column(name="libro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="fecha_publicacion")
    private Date fechaPublicacion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id")
    private Autor autor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="editorial_id")
    private Editorial editorial;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    public Libro(){}
    public Libro(String titulo, Date fechaPublicacion, Autor autor, Editorial editorial, Categoria categoria) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", autor=" + autor.toString() +
                ", editorial=" + editorial.toString() +
                ", categoria=" + categoria.toString() +
                '}';
    }
}
