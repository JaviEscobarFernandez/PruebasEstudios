package es.efjavi.pooherencia.ejemplo;

import es.efjavi.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {
        System.out.println("======== Creando la instancia de la clase Alumno ========");
        Alumno alumno = new Alumno();
        alumno.setNombre("Javi");
        alumno.setApellido("Escobar Fernández");
        alumno.setInstitucion("Instituto Nacional");
        alumno.setNotaLenguaje(5.8);
        alumno.setNotaHistoria(8.2);
        alumno.setNotaMatematicas(7.3);

        System.out.println("======== Creando la instancia de la clase AlumnoInternacional ========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(9.2);
        alumnoInt.setNotaLenguaje(8.1);
        alumnoInt.setNotaHistoria(6.2);
        alumnoInt.setNotaMatematicas(5.1);

        System.out.println("======== Creando la instancia de la clase Profesor ========");
        Profesor profesor = new Profesor();
        profesor.setNombre("Lucía");
        profesor.setApellido("Pérez Martínez");
        profesor.setAsignatura("Matemáticas");

        System.out.println("======= - =======");
        System.out.println(alumno.getNombre() + " " + alumno.getApellido() +
                " " + alumno.getInstitucion());
        System.out.println(alumnoInt.getNombre() + " " + alumnoInt.getApellido() +
                " " + alumnoInt.getInstitucion() + " " + alumnoInt.getPais());
        System.out.println("Profesor " + profesor.getAsignatura() +
                ": " + profesor.getNombre() + " " + profesor.getApellido());

        Class clase = alumnoInt.getClass();
        while (clase.getSuperclass() != null) {
            String claseHija = clase.getName();
            String clasePadre = clase.getSuperclass().getName();
            System.out.println(claseHija + " es una subclase de la superclase " + clasePadre);
            clase = clase.getSuperclass();
        }
    }
}
