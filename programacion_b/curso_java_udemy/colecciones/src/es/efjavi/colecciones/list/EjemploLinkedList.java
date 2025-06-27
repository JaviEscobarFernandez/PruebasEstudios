package es.efjavi.colecciones.list;

import es.efjavi.colecciones.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {
        LinkedList<Alumno> linked = new LinkedList<>();
        System.out.println(linked + ", size = " + linked.size());
        System.out.println("Está vacía = " + linked.isEmpty());

        linked.add(new Alumno("Juan", 5));
        linked.add(new Alumno("Maria", 6));
        linked.add(new Alumno("Pedro", 4));
        linked.add(new Alumno("Rosa", 8));
        linked.add(new Alumno("Ana", 7));
        linked.add(new Alumno("Zulema", 9));
        linked.add(new Alumno("Lucas", 9));
        System.out.println(linked + ", size = " + linked.size());

        linked.addFirst(new Alumno("Manolo", 5));
        linked.addLast(new Alumno("Aitor", 9));
        System.out.println(linked + ", size = " + linked.size());

        System.out.println("Primer alumno de la lista: " + linked.getFirst());
        System.out.println("Último alumno de la lista: " + linked.getLast());
        System.out.println("Segundo alumno de la lista: " + linked.get(2));

        // Alumno manolo = linked.pop();
        // linked.pollLast();
        linked.removeFirst();
        linked.removeLast();
        System.out.println(linked + ", size = " + linked.size());

        linked.remove(new Alumno("Lucas", 9));
        System.out.println(linked + ", size = " + linked.size());

        Alumno a = new Alumno("Raquel", 8);
        linked.addLast(a);
        System.out.println(linked + ", size = " + linked.size());
        System.out.println("La posición de Raquel en la lista es: " + linked.indexOf(a));

        linked.remove(2);
        System.out.println(linked + ", size = " + linked.size());
        System.out.println("La posición de Raquel en la lista es: " + linked.indexOf(a));

        linked.set(3, new Alumno("Macarena", 6));
        System.out.println(linked + ", size = " + linked.size());

        ListIterator<Alumno> li = linked.listIterator();
        System.out.println("Iterando la lista de alumnos:");
        while (li.hasNext()) {
            System.out.println(li.next());
        }

        System.out.println();
        System.out.println("Rebobinando iteracion de la lista de alumnos:");
        while(li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }
}
