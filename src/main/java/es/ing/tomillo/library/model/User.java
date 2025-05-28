package es.ing.tomillo.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;    // Nombre del usuario
    private int id;         // ID único del usuario
    private final List<Book> borrowedBooks; // Libros que tiene prestados
    private static final int MAX_BORROWED_BOOKS = 5;    // Máximo de libros que puede prestar

    // Constructor del usario
    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>(); // Inicializa lista vacía de libros prestados
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;   // Modifica el nombre del usuario
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;   // Modifica el ID del usuario
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;   // Devuelve la lista de libros que tiene prestados
    }

    public int getBookCount() {
        return borrowedBooks.size();    // Devuelve la cantidad de libros prestados
    }

    // Método para prestar un libro al usuario
    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < MAX_BORROWED_BOOKS && book.isAvailable()) {
            borrowedBooks.add(book);    // Añade el libro a la lista de prestados
            book.setAvailable(false);   // Marca el libro como no disponible
            System.out.println(name + " ha prestado el libro: " + book.getTitle());
            return true;
        }
        // Si ya tiene el máximo de libros o el libro no está disponible
        System.out.println("No se puede prestar el libro: " + book.getTitle());
        return false;
    }

    // Método para devolver un libro
    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book); // Elimina el libro de la lista de prestados
            book.setAvailable(true);    // Marca el libro como disponible otra vez
            System.out.println(name + " ha devuelto el libro: " + book.getTitle());
            return true;
        }
        // Si el libro no está en la lista de prestados
        System.out.println("Este libro no está prestado por " + name);
        return false;
    }

    // Método para reservar un libro que no está disponible
    public void reserveBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println(name + " ha reservado el libro: " + book.getTitle());
        } else {
            System.out.println("El libro está disponible, no es necesario reservarlo.");
        }
    }

    // Representación del usuario como texto
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }

    // Dos usuarios son iguales si tienen el mismo ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}