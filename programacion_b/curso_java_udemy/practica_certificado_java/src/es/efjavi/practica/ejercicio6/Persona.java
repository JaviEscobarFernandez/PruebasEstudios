package es.efjavi.practica.ejercicio6;

public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;

    public Persona(String nombre, String apellidos, String dni, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getDni() { return dni; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Apellidos: " + apellidos + " - DNI: " + dni + " - Edad: " + edad;
    }
}
