package es.efjavi.practica.ejercicio8;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Pelota Futbol", 2.4, 45);
        Producto producto2 = new Producto("Raqueta", 10.45, 100);

        try {
            producto1.vender(20);
            System.out.println(producto1);

            producto1.reponer(50);
            System.out.println(producto1);

            producto2.vender(10);
            System.out.println(producto2);

            producto2.vender(10);
            System.out.println(producto2);

            producto2.reponer(40);
            System.out.println(producto2);

            producto2.vender(1000);
            System.out.println(producto2);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
