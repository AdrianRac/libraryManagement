// Paquete donde se encuentra esta clase (estructura de carpetas del proyecto)
package es.ing.tomillo.library.model;

// Importamos la clase Objects para usar métodos como hashCode
import java.util.Objects;

//Clase que representa un libro en la biblioteca.
public class Book {
    // Atributos privados para encapsular los datos del libro
    private String title;   // Título del libro
    private String author;  // Autor del libro
    private String isbn;    // Código ISBN único para cada libro
    private boolean available;  // Indica si el libro está disponible para préstamo

    // Constructor: se utiliza para crear objetos Book con valores iniciales.
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title; // Asignamos el título al atributo
        this.author = author;   // Asignamos el autor al atributo
        this.isbn = isbn;   // Asignamos el ISBN al atributo
        this.available = available;  // Asignamos si está disponible
    }

    // Métodos "Getters y setters" para acceder y modificar los atributos
    // Los "getters" devuelven el valor de los atributos
    // Los "setters" permiten cambiar el valor de los atributos
    public String getTitle() {
        return title;   // Devuelve el título del libro
    }

    public void setTitle(String title) {
        this.title = title; // Cambia el título del libro
    }

    public String getAuthor() {
        return author;  // Devuelve el autor del libro
    }

    public void setAuthor(String author) {
        this.author = author;   // Cambia el autor del libro
    }

    public String getIsbn() {
        return isbn;    // Devuelve el código ISBN
    }

    public boolean isAvailable() {
        return available;   // Devuelve si el libro está disponible
    }

    public void setAvailable(boolean available) {
        this.available = available; // Cambia el estado de disponibilidad
    }
    //toString() -- Este método se ejecuta cuando queremos imprimir el objeto Book por consola.
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +  // Muestra el título
                ", author='" + author + '\'' +  // Muestra el autor
                ", isbn='" + isbn + '\'' +      // Muestra el ISBN
                ", available=" + available +    // Muestra si está disponible
                '}';
    }

    //  equals() --  Compara si dos objetos Book son iguales.
    // Se considera que dos libros son iguales si tienen el mismo ISBN.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si son el mismo objeto en memoria, son iguales
        if (!(o instanceof Book)) return false; // Si no es un objeto de tipo Book, no son iguales
        Book book = (Book) o;   // Convertimos el objeto a tipo Book
        return isbn.equals(book.isbn);  // Comparar por ISBN (clave única del libro)
    }

    // hashCode() -- Este método genera un número único para cada objeto basado en su ISBN.
    // Es necesario cuando usamos estructuras como HashSet o HashMap.
    @Override
    public int hashCode() {
        return Objects.hash(isbn);  // Calcula el hash basado solo en el ISBN
    }
}


