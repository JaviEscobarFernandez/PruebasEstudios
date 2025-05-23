package programacion_b_vt_09_ejercicio_03;

import java.io.Serializable;

public class Alumno implements Serializable{
    private static final long serialVersionUID = 1L; // Simplemente para evitar warning por la interfaz serializable.
    private int id;
    private String nombre;

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Alumno [id = " + id + ", nombre = " + nombre + "]";
    }
}
