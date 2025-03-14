package ejercicio_clase;

public class Perro extends Animal {
    // atributos
    private String raza;

    // constructor
    public Perro(String nombre, String color, int edad) {
        super(nombre, color, edad);
    }

    // sobrecarga constructor con raza
    public Perro(String nombre, String color, int edad, String raza) {
        super(nombre, color, edad);
        this.raza = raza;
    }

    // getters
    public String getRaza() { return this.raza; }

    // setters
    public void setRaza(String r) { raza = r; }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }
}
