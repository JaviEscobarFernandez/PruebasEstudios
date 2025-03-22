package ejercicio_10;

public class Empleado {
    private String nombre;
    private double sueldo;

    public Empleado(String n, double s) {
        this.nombre = n;
        this.sueldo = s;
    }

    public String getNombre() { return this.nombre; }
    public double getSueldo() { return this.sueldo; }

    public void setNombre(String n) { this.nombre = n; }
    public void setSueldo(double s) { this.sueldo = s; }
}
