package codigo;

public class Personaje {
    // Atributos
    private String nombre;
    private int salud;
    private int nivel;

    // Constructor
    Personaje(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    // Setters
    public void setNombre(String n) { nombre = n; }
    public void setSalud(int s) { salud = s; }
    public void setNivel(int n) { nivel = n; }

    // Metodos adicionales
    public boolean estaMuerto() { return salud == 0; }
}
