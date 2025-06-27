package es.efjavi.colecciones.set;

import es.efjavi.colecciones.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        // List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Maria", 6));
        sa.add(new Alumno("Pedro", 4));
        sa.add(new Alumno("Rosa", 8));
        sa.add(new Alumno("Ana", 7));
        sa.add(new Alumno("Zulema", 9));
        sa.add(new Alumno("Lucas", 9));
        sa.add(new Alumno("Lucas B", 9));
        sa.add(new Alumno("Lucas", 4));

        System.out.println(sa);

        System.out.println("Iterando lista de alumnos con un foreach tradicional");
        for (Alumno a : sa) {
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando lista de alumnos con un while iterando");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando lista de alumnos con foreach con expresion lamda");
        sa.forEach(a -> System.out.println(a.getNombre()));

        /* System.out.println("Iterando lista (array) de alumnos con un for tradicional");
        for (int i = 0; i < sa.size(); i++) {
            Alumno a = sa.get(i);
            System.out.println(a.getNombre());
        } */
    }
}
