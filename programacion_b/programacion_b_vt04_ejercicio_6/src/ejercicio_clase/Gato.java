package ejercicio_clase;

public class Gato implements Animal {
    // atributos
    private String nombre;
    private String color;
    private int edad;

    // constructor
    public Gato(String nombre, String color, int edad) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }

    // getters
    public String getNombre() { return this.nombre; }
    public String getColor() { return this.color; }
    public int getEdad() { return this.edad; }

    // setters
    public void setNombre(String n) { nombre = n; }
    public void setColor(String c) { color = c; }
    public void setEdad(int e) { edad = e; }

    @Override
    public void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + " está comiendo pescado.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + " está durmiendo... (ZZzzzZzZZzzzZzZzz)");
    }
}
