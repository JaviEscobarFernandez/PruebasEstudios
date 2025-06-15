package almacen;

public class Persona {
    private String nombre;
    private String apellidos;
    private String DNI;

    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getDNI() { return DNI; }

    @Override
    public String toString() {
        return "Nombre: '" + getNombre() + '\'' +
                ", Apellidos: '" + getApellidos() + '\'' +
                ", DNI: '" + getDNI() + '\'';
    }
}
