package es.efjavi.colecciones.list;

import es.efjavi.colecciones.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {
        List<Alumno> al = new ArrayList<>();
        System.out.println(al + ", size = " + al.size());
        System.out.println("Está vacía = " + al.isEmpty());

        al.add(new Alumno("Juan", 5));
        al.add(new Alumno("Maria", 6));
        al.add(new Alumno("Pedro", 4));
        al.add(new Alumno("Rosa", 8));
        al.add(new Alumno("Ana", 7));
        al.add(2, new Alumno("Zulema", 9));
        al.set(3, new Alumno("Lucas", 9));

        System.out.println(al + ", size = " + al.size());

        // al.remove(new Alumno("Maria", 6)); // Esto funciona por el metodo equals de Alumno
        al.remove(2);
        System.out.println(al + ", size = " + al.size());

        boolean b = al.contains(new Alumno("Zulema", 6));
        System.out.println("La lista contiene a Zulema? " + b);

        Object a[] = al.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Desde el array: " + a[i]);
        }
    }
}
