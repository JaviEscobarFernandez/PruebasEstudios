package es.efjavi.colecciones.set;

import es.efjavi.colecciones.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        // Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNombre().compareTo(a.getNombre()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNombre));
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Maria", 6));
        sa.add(new Alumno("Pedro", 4));
        sa.add(new Alumno("Rosa", 8));
        sa.add(new Alumno("Ana", 7));
        sa.add(new Alumno("Zulema", 9));
        sa.add(new Alumno("Lucas", 9));

        System.out.println(sa);
    }
}
