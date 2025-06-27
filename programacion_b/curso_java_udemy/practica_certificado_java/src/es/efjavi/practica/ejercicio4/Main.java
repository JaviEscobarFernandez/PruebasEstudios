package es.efjavi.practica.ejercicio4;

public class Main {
    public static void main(String[] args) {
        Conducible[] vehiculos = {
                new Coche("Opel", 5),
                new Moto("Yamaha", 250),
                new Coche("Ferrari", 3),
                new Moto("Honda", 500)
        };

        for (Conducible v : vehiculos) {
            if (v instanceof Coche) {
                Coche c = (Coche) v;
                c.mostrarInfo();
                c.conducir();
            } else if (v instanceof Moto) {
                Moto m = (Moto) v;
                m.mostrarInfo();
                m.conducir();
            }
            System.out.println();
        }
    }
}
