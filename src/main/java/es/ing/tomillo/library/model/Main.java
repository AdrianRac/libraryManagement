package es.ing.tomillo.library.model;

import es.ing.tomillo.library.model.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        biblioteca.cargarDatosIniciales();    // Cargar usuarios y libros predefinidos
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> registrarLibro();
                case 3 -> prestarLibro();
                case 4 -> devolverLibro();
                case 5 -> buscarPorTitulo();
                case 6 -> buscarPorAutor();
                case 7 -> mostrarUsuarios();
                case 8 -> mostrarLibros();
                case 0 -> System.out.println("Saliendo del sistema. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ BIBLIOTECA ---");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar libro");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Buscar libro por título");
        System.out.println("6. Buscar libro por autor");
        System.out.println("7. Mostrar usuarios");
        System.out.println("8. Mostrar libros");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarUsuario() {
        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());

        User usuario = new User(nombre, id);
        biblioteca.addUser(usuario);
        System.out.println("Usuario registrado.");
    }

    private static void registrarLibro() {
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book libro = new Book(titulo, autor, isbn, true);
        biblioteca.addBook(libro);
        System.out.println("Libro registrado.");
    }

    private static void prestarLibro() {
        User usuario = seleccionarUsuario();
        Book libro = seleccionarLibro();

        if (usuario != null && libro != null) {
            biblioteca.prestarLibro(usuario, libro);
        }
    }

    private static void devolverLibro() {
        User usuario = seleccionarUsuario();
        Book libro = seleccionarLibro();

        if (usuario != null && libro != null) {
            biblioteca.devolverLibro(usuario, libro);
        }
    }

    private static void buscarPorTitulo() {
        System.out.print("Título a buscar: ");
        String titulo = scanner.nextLine();
        List<Book> resultados = biblioteca.buscarPorTitulo(titulo);
        resultados.forEach(System.out::println);
    }

    private static void buscarPorAutor() {
        System.out.print("Autor a buscar: ");
        String autor = scanner.nextLine();
        List<Book> resultados = biblioteca.buscarPorAutor(autor);
        resultados.forEach(System.out::println);
    }

    private static void mostrarUsuarios() {
        System.out.println("--- Usuarios registrados ---");
        for (User usuario : biblioteca.getUsuarios()) {
            System.out.println(usuario);
        }
    }

    private static void mostrarLibros() {
        System.out.println("--- Libros registrados ---");
        for (Book libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }
    }

    private static User seleccionarUsuario() {
        mostrarUsuarios();
        System.out.print("ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        return biblioteca.getUsuarios().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Usuario no encontrado.");
                    return null;
                });
    }

    private static Book seleccionarLibro() {
        mostrarLibros();
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        return biblioteca.getLibros().stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Libro no encontrado.");
                    return null;
                });
    }
}