package es.efjave.appfacturas;

import es.efjave.appfacturas.modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setDni("12345679-C");
        cliente.setNombre("Javi");

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una descripción para la factura: ");
        Factura factura = new Factura(sc.nextLine(), cliente);

        Producto producto;
        System.out.println();
        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("Introduce el producto nº: " + producto.getCodigo() + ": ");
            producto.setNombre(sc.nextLine());

            System.out.print("Introduce el precio del producto: ");
            producto.setPrecio(sc.nextDouble());

            System.out.print("Introduce la cantidad: ");
            factura.addItemFactura(new ItemFactura(sc.nextInt(), producto));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(factura);
    }
}
