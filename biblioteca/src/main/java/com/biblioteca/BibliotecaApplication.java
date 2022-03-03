package com.biblioteca;

import com.biblioteca.entidades.Autor;
import com.biblioteca.entidades.Categoria;
import com.biblioteca.entidades.Editorial;
import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.AutorService;
import com.biblioteca.servicios.CategoriaService;
import com.biblioteca.servicios.EditorialService;
import com.biblioteca.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EditorialService editorialService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long millis=System.currentTimeMillis();
		Date date=new Date(millis);

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("Romance");
		Categoria categoria3 = new Categoria("Accion");
		Categoria categoria4 = new Categoria("Ciencia Ficcion");
		categoriaService.guardarCategoria(categoria1);
		categoriaService.guardarCategoria(categoria2);
		categoriaService.guardarCategoria(categoria3);
		categoriaService.guardarCategoria(categoria4);

		Autor autor1 = new Autor("Miguel de Cervantes",date, "Americano");
		Autor autor2 = new Autor("Geoffrey Chaucer",date, "Argentino");
		Autor autor3 = new Autor("Antón Chéjov",date, "Chileno");
		Autor autor4 = new Autor("Louis-Ferdinand Céline",date, "Chino");
		autorService.guardarAutor(autor1);
		autorService.guardarAutor(autor2);
		autorService.guardarAutor(autor3);
		autorService.guardarAutor(autor4);

		Editorial editorial1 = new Editorial("Editorial 1");
		Editorial editorial2 = new Editorial("Editorial 2");
		Editorial editorial3 = new Editorial("Editorial 3");
		editorialService.guardarEditorial(editorial1);
		editorialService.guardarEditorial(editorial2);
		editorialService.guardarEditorial(editorial3);

		Libro libro1 = new Libro("Viaje al fin de la noche",date,autor4,editorial3,categoria2);
		Libro libro2 = new Libro("Don Quijote de la Mancha",date,autor1,editorial3,categoria3);
		Libro libro3 = new Libro("Los cuentos de Canterbury",date,autor2,editorial1,categoria1);
		Libro libro4 = new Libro("Relatos cortos",date,autor2,editorial3,categoria2);

		libroService.guardarLibro(libro1);
		libroService.guardarLibro(libro2);
		libroService.guardarLibro(libro3);
		libroService.guardarLibro(libro4);

		autorService.getAutores().forEach(autor -> System.out.println(autor));
		editorialService.getEditoriales().forEach(editorial -> System.out.println(editorial));
		categoriaService.getCategorias().forEach(categoria -> System.out.println(categoria));
		libroService.getLibros().forEach(libro-> System.out.println(libro));

	}
}
