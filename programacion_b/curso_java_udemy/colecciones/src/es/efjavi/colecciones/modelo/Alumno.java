package es.efjavi.colecciones.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{
    private String nombre;
    private Integer nota;

    public Alumno() { }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " nota: " + nota;
    }

    @Override
    public int compareTo(Alumno alumno) {
        /*if (nombre == null)
            return 0;
        return nombre.compareTo(alumno.getNombre());*/
        // return nota.equals(alumno.getNota()) ? 0 : nota > alumno.getNota() ? 1 : -1;
        if (nota == null)
            return 0;
        return nota.compareTo(alumno.getNota());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
