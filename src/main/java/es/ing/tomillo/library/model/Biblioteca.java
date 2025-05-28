package es.ing.tomillo.library.model;

import es.ing.tomillo.library.util.DatosIniciales;
import java.util.ArrayList;
import java.util.List;
import es.ing.tomillo.library.model.Book;
import es.ing.tomillo.library.model.User;

public class Biblioteca {
    private List<Book> libros;  // Lista de todos los libros de la biblioteca
    private List<User> usuarios;    // Lista de todos los usuarios registrados

    // Constructor: inicializa las listas vacías
    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    // Cargar libros y usuarios iniciales desde la clase DatosIniciales
    public void cargarDatosIniciales() {
        libros.addAll(DatosIniciales.LIBROS_INICIALES);
        usuarios.addAll(DatosIniciales.USUARIOS_INICIALES);
    }


    // Agrega un libro nuevo a la biblioteca
    public void addBook(Book libro) {
        libros.add(libro);
    }

    // Agrega un nuevo usuario a la biblioteca
    public void addUser(User usuario) {
        usuarios.add(usuario);
    }

    // Presta un libro a un usuario
    public boolean prestarLibro(User usuario, Book libro) {
        // Solo se presta si el usuario y el libro existen en la biblioteca
        if (usuarios.contains(usuario) && libros.contains(libro)) {
            return usuario.borrowBook(libro);
        }
        return false;
    }

    // Devuelve un libro que estaba prestado
    public boolean devolverLibro(User usuario, Book libro) {
        // Solo se devuelve si el usuario y el libro existen en la biblioteca
        if (usuarios.contains(usuario) && libros.contains(libro)) {
            return usuario.returnBook(libro);
        }
        return false;
    }

    // Busca libros por título (ignorando mayúsculas/minúsculas)
    public List<Book> buscarPorTitulo(String titulo) {
        List<Book> resultado = new ArrayList<>();
        for (Book libro : libros) {
            if (libro.getTitle().equalsIgnoreCase(titulo)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // Busca libros por autor (ignorando mayúsculas/minúsculas)
    public List<Book> buscarPorAutor(String autor) {
        List<Book> resultado = new ArrayList<>();
        for (Book libro : libros) {
            if (libro.getAuthor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // Devuelve la lista completa de libros
    public List<Book> getLibros() {
        return libros;
    }

    // Devuelve la lista completa de usuarios
    public List<User> getUsuarios() {
        return usuarios;
    }
}
