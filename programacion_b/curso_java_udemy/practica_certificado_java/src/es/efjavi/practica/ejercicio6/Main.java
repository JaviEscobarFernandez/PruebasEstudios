package es.efjavi.practica.ejercicio6;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> estudiantes = new LinkedList<>();
        estudiantes.add(new Estudiante("Javi", "Escobar Fernández", "12345678-A", 33, "Programación", 9.9));
        estudiantes.add(new Estudiante("Genaro", "Martinez Olmeda", "9887762-F", 32, "Matemáticas", 9.2));

        Estudiante estudiante3 = new Estudiante("Roberto", "Gonzalez Blanco", "345245643-A", 24);
        estudiante3.setAsignatura("Historia");
        estudiante3.setNota(9.9);
        estudiantes.add(estudiante3);

        System.out.println("Listando estudiantes:");
        estudiantes.forEach(System.out::println);
    }
}
