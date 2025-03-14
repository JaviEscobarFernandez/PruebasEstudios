package ejercicio_clase;

public class Gato extends Animal {

    // constructor
    public Gato(String nombre, String color, int edad) {
        super(nombre, color, edad);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + " está comiendo pescado.");
    }
}
