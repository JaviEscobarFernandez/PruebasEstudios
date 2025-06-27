package es.efjavi.practica.ejercicio1;

import es.efjavi.practica.ejercicio1.exception.BibliotecaLlenaException;
import es.efjavi.practica.ejercicio1.exception.LibroNoEncontradoException;
import es.efjavi.practica.ejercicio1.exception.MaterialException;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        try {
            biblioteca.agregarMaterial(new Libro("Dracula", "Bram Stoker", "123-ASF"));
            biblioteca.agregarMaterial(new Libro("Viaje al centro de la tierra", "Julio Verne", "345-VDA"));
            biblioteca.agregarMaterial(new Libro("El Señor de los Anillos", "J.R. Tolkien", "456-DGD"));
        } catch (BibliotecaLlenaException | MaterialException e) {
            System.err.println(e);
        }
        biblioteca.listarTodosLosLibros();
        System.out.println();

        validarMostrarLibro(biblioteca, "Dracula");
        validarMostrarLibro(biblioteca, "El Señor de los Anillos");
        validarMostrarLibro(biblioteca, "Libro falso 1234");

        try {
            Libro libro1 = biblioteca.buscarLibroPorTitulo("Viaje al centro de la tierra");
            libro1.prestar();
            libro1.devolver();
        } catch (LibroNoEncontradoException e) {
            System.err.println(e);
        }
    }

    private static void validarMostrarLibro(Biblioteca biblioteca, String titulo) {
        try {
            Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
            System.out.println("Libro localizado, imprimiendo informacion: ");
            libro.mostrarInformacion();
            System.out.println();
        } catch (LibroNoEncontradoException e) {
            System.err.println(e);
        }
    }
}
