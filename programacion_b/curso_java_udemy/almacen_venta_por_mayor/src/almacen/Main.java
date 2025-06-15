package almacen;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor1 = new Vendedor("Juan", "Pedro Luis", "123456587-A","Juanito", "Valencia");
        vendedor1.addProducto(new Perecedero("Yogurt", 1.24, new Date(2025, Calendar.DECEMBER, 4)));
        vendedor1.addProducto(new NoPerecedero("Bombilla led", 3.50, "Rojo"));
        vendedor1.addProducto(new Limpieza("Champú anticaspa", 4.2, "Higiene"));

        Vendedor vendedor2 = new Vendedor("Pepe", "Muñoz Rodriguez", "344553221-A", "Petete", "Cuenca");
        vendedor2.addProducto(new Perecedero("Chorizo Revilla", 3.2, new Date(2026, Calendar.MARCH, 24)));
        vendedor2.addProducto(new NoPerecedero("Balón Playa", 0.83, "Multicolor"));
        vendedor2.addProducto(new Limpieza("Lejía", 4.56, "Sanitario"));

        Cliente cliente1 = new Cliente("Javi", "Escobar Fernandez", "11112222-A");

        imprimirInfo(vendedor1);
        imprimirInfo(vendedor2);
        imprimirInfo(cliente1);
    }

    private static void imprimirInfo(Persona persona) {
        System.out.println("===================");
        System.out.println(persona);
        System.out.println("===================");
        System.out.println();
    }
}
