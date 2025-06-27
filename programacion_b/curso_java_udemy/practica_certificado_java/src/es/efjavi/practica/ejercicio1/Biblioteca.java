package es.efjavi.practica.ejercicio1;

import es.efjavi.practica.ejercicio1.exception.BibliotecaLlenaException;
import es.efjavi.practica.ejercicio1.exception.LibroNoEncontradoException;
import es.efjavi.practica.ejercicio1.exception.MaterialException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Biblioteca {
    private List<MaterialBiblioteca> materiales;
    private HashMap<String, MaterialBiblioteca> mapaMateriales;
    static final int MAX_MATERIAL = 10;

    public Biblioteca() {
        materiales = new ArrayList<>();
        mapaMateriales = new HashMap<>();
    }

    public void agregarMaterial(MaterialBiblioteca material) throws BibliotecaLlenaException, MaterialException {
        if (materiales.size() >= MAX_MATERIAL)
            throw new BibliotecaLlenaException("ERROR: Se ha alcanzado el limite para agregar material.");
        if (material == null) {
            throw new BibliotecaLlenaException("ERROR: Material inválido, no puede añadirse.");
        }
        materiales.add(material);

        if (mapaMateriales.get(material.getIdMaterial()) != null)
            throw new MaterialException("ERROR: El material que se intenta añadir ya ha sido añadido previamente.");

        mapaMateriales.put(material.getIdMaterial(), material);
        System.out.println(material + " añadido correctamente");
    }

    public MaterialBiblioteca buscarMaterialPorId(String id) throws MaterialException {
        MaterialBiblioteca material = mapaMateriales.get(id);
        if (material == null)
            throw new MaterialException("ERROR: El material no ha sido localizado.");

        return material;
    }

    public Libro buscarLibroPorTitulo(String titulo) throws LibroNoEncontradoException {
        System.out.println("Buscando libro: " + titulo);
        for (MaterialBiblioteca m : materiales) {
            if (m instanceof Libro) {
                Libro libro = (Libro) m;
                if (libro.getTitulo().equals(titulo))
                    return libro;
            }
        }
        throw new LibroNoEncontradoException("ERROR: El libro no ha sido localizado.");
    }

    public void listarTodosLosLibros() {
        System.out.println("Listando todos los libros de la Biblioteca:");
        for (MaterialBiblioteca m : materiales) {
            if (!(m instanceof Libro))
                continue;

            Libro libro = (Libro) m;
            System.out.println("\n===============");
            libro.mostrarInformacion();
            System.out.println("===============");
        }
    }

    public void listarTodoElMaterial() {
        for (MaterialBiblioteca m : materiales) {
            System.out.println("\n===============");
            System.out.println(m);
            System.out.println("===============");
        }
    }
}
