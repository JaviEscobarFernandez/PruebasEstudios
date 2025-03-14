package ejercicio_clase;

public class Perro implements Animal {
    // atributos
    private String nombre;
    private String color;
    private int edad;
    private String raza;

    // constructor
    public Perro(String nombre, String color, int edad) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }

    // sobrecarga constructor con raza
    public Perro(String nombre, String color, int edad, String raza) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.raza = raza;
    }

    // getters
    public String getNombre() { return this.nombre; }
    public String getColor() { return this.color; }
    public int getEdad() { return this.edad; }
    public String getRaza() { return this.raza; }

    // setters
    public void setNombre(String n) { nombre = n; }
    public void setColor(String c) { color = c; }
    public void setEdad(int e) { edad = e; }
    public void setRaza(String r) { raza = r; }

    @Override
    public void comer() {
        System.out.println(getNombre() + " está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + " está durmiendo... (ZZzzzZzZZzzzZzZzz)");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }
}
