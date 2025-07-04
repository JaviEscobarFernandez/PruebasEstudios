package es.efjavi.poointerfaces.imprenta.modelo;

public class Persona {
    private String nombre;
    private String apellidos;

    public Persona() { }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos();
    }
}
