package es.efjavi.practica.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal[] animales = {
                new Perro("Zeus"),
                new Perro("Toby"),
                new Gato("Simba"),
                new Gato("Estrella")
        };

        for (Animal a : animales) {
            a.hacerSonido();
        }
    }
}
