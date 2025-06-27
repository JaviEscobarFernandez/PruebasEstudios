package es.efjavi.practica.ejercicio6;

public class Estudiante extends Persona {
    private String asignatura;
    private double nota;
    private int idEstudiante;
    private static int autoincrementId;

    public Estudiante(String nombre, String apellidos, String dni, int edad) {
        super(nombre, apellidos, dni, edad);
        idEstudiante = ++autoincrementId;
    }

    public Estudiante(String nombre, String apellidos, String dni, int edad, String asignatura, double nota) {
        this(nombre, apellidos, dni, edad);
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public int getIdEstudiante() { return idEstudiante; }

    @Override
    public String toString() {
        return super.toString() + "\nIdentificador de Estudiante: " + idEstudiante +
                " - Asignatura: " + asignatura + " - Nota: " + nota + "\n";
    }
}
