package es.efjavi.colecciones.list;

import es.efjavi.colecciones.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> sa = new LinkedList<>();
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Maria", 6));
        sa.add(new Alumno("Pedro", 4));
        sa.add(new Alumno("Rosa", 8));
        sa.add(new Alumno("Ana", 7));
        sa.add(new Alumno("Zulema", 9));
        sa.add(new Alumno("Lucas", 9));
        sa.add(new Alumno("Lucas B", 9));
        sa.add(new Alumno("Lucas", 4));

        // Diferentes formas de ordenar la lista
        // Collections.sort(sa, (a, b) -> b.getNota().compareTo(a.getNota()));
        // sa.sort((a, b) -> b.getNota().compareTo(a.getNota()));
        sa.sort(Comparator.comparing(Alumno::getNota).reversed());
        System.out.println(sa);

        System.out.println("Iterando lista de alumnos con foreach con expresion lamda");
        sa.forEach(System.out::println);

    }
}
