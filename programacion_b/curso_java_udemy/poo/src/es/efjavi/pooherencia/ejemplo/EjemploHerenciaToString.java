package es.efjavi.pooherencia.ejemplo;

import es.efjavi.pooherencia.Alumno;
import es.efjavi.pooherencia.AlumnoInternacional;
import es.efjavi.pooherencia.Persona;
import es.efjavi.pooherencia.Profesor;

public class EjemploHerenciaToString {
    public static void main(String[] args) {
        System.out.println("======== Creando la instancia de la clase Alumno ========");
        Alumno alumno = new Alumno("Javi", "Escobar Fernández", 12, "Instituto Nacional");
        alumno.setNotaLenguaje(5.8);
        alumno.setNotaHistoria(8.2);
        alumno.setNotaMatematicas(7.3);
        alumno.setEmail("javi@correo.es");

        System.out.println("======== Creando la instancia de la clase AlumnoInternacional ========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter","Gosling","Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(9.2);
        alumnoInt.setNotaLenguaje(8.1);
        alumnoInt.setNotaHistoria(6.2);
        alumnoInt.setNotaMatematicas(5.1);
        alumnoInt.setEmail("peter@correo.es");

        System.out.println("======== Creando la instancia de la clase Profesor ========");
        Profesor profesor = new Profesor("Lucía", "Pérez Martínez", "Matemáticas");
        profesor.setEdad(37);
        profesor.setEmail("lucia@correoprofesor.es");

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }

    private static void imprimir(Persona persona) {
        System.out.println(persona);
    }
}
