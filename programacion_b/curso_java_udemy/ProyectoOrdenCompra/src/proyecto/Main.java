package proyecto;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Cliente paco = new Cliente("Paco", "Pérez");
        OrdenCompra orden1 = new OrdenCompra("Productos de " + paco.getNombre() + " " + paco.getApellido());
        orden1.setCliente(paco);
        orden1.setFecha(new Date());
        orden1.addProducto(new Producto("Bimbo", "Pan", 1));
        orden1.addProducto(new Producto("Orlando", "Tomate", 2));
        orden1.addProducto(new Producto("Hornimans", "Té", 1));
        orden1.addProducto(new Producto("El pozo", "Jamón cocido", 4));
        System.out.println(orden1.imprimirOrden());

        System.out.println();
        Cliente sara = new Cliente("Sara", "Martínez");
        OrdenCompra orden2 = new OrdenCompra("Productos de " + sara.getNombre() + " " + sara.getApellido());
        orden2.setCliente(sara);
        orden2.setFecha(new Date());
        orden2.addProducto(new Producto("La piara", "Paté", 1));
        orden2.addProducto(new Producto("Caserío", "Queso", 2));
        orden2.addProducto(new Producto("Lays", "Patatas", 3));
        orden2.addProducto(new Producto("Amstel", "Cerveza", 6));
        System.out.println(orden2.imprimirOrden());
        System.out.println();

        Cliente raquel = new Cliente("Raquel", "Rodriguez");
        OrdenCompra orden3 = new OrdenCompra("Productos de " + raquel.getNombre() + " " + raquel.getApellido());
        orden3.setCliente(raquel);
        orden3.setFecha(new Date());
        orden3.addProducto(new Producto("Donuts", "Donut", 2));
        orden3.addProducto(new Producto("Frigo", "Helado", 3));
        orden3.addProducto(new Producto("Coca-cola", "Coca-cola", 4));
        orden3.addProducto(new Producto("Fanta", "Fanta Naranja", 3));
        System.out.println(orden3.imprimirOrden());
    }
}
