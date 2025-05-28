package es.ing.tomillo.library.util;

import es.ing.tomillo.library.model.Book;
import es.ing.tomillo.library.model.User;

import java.util.Arrays;
import java.util.List;

public class DatosIniciales {

    // Lista de libros
    public static final List<Book> LIBROS_INICIALES = Arrays.asList(
            new Book("Harry Potter y la piedra filosofal", "J.K. Rowling", "1", true),
            new Book("El señor de los anillos", "J.R.R. Tolkien", "2", true),
            new Book("Cien años de soledad", "Gabriel García Márquez", "3", true),
            new Book("El Principito", "Antoine de Saint-Exupéry", "4", true),
            new Book("Don Quijote de la Mancha", "Miguel de Cervantes", "5", true)
    );

    // Lista de usuarios
    public static final List<User> USUARIOS_INICIALES = Arrays.asList(
            new User("Lucía Pérez", 1),
            new User("Mario Sánchez", 2),
            new User("Elena Ruiz", 3),
            new User("Javier Torres", 4),
            new User("Sara López", 5)
    );
}
