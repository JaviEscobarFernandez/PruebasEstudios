package es.efjavi.pooherencia.ejemplo;

import es.efjavi.pooherencia.*;

public class EjemploHerenciaConstructores {
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
        System.out.println("Imprimiendo los datos del tipo Persona:");
        System.out.println("======= - =======");
        System.out.println("nombre: " + persona.getNombre() +
                ", apellido: " + persona.getApellido() +
                ", edad " + persona.getEdad() +
                ", email: " + persona.getEmail());

        if (persona instanceof Alumno) {
            Alumno alumno = (Alumno) persona;
            System.out.println("Imprimiendo los datos del tipo Alumno:");
            System.out.println("Institución: " + alumno.getInstitucion());
            System.out.println("Nota Matemáticas: " + alumno.getNotaMatematicas());
            System.out.println("Nota Historia: " + alumno.getNotaHistoria());
            System.out.println("Nota Lenguaje: " + alumno.getNotaLenguaje());

            if (persona instanceof AlumnoInternacional) {
                System.out.println("Imprimiendo los datos del tipo AlumnoInternacional:");
                AlumnoInternacional alumnoInt = (AlumnoInternacional) persona;
                System.out.println("Nota Idiomas: " + alumnoInt.getNotaIdiomas());
                System.out.println("País: " + alumnoInt.getPais());
            }
            System.out.println("===================== Sobrescritura promedio ===============================");
            System.out.println(((Alumno)persona).calcularPromedio());
        }

        if (persona instanceof Profesor) {
            Profesor profesor = (Profesor) persona;
            System.out.println("Imprimiendo los datos del tipo Profesor:");
            System.out.println("Asignatura: "+ profesor.getAsignatura());
        }

        System.out.println("===================== Sobrescritura saludar ===============================");
        System.out.println(persona.saludar());
        System.out.println("====================================================");

    }
}
