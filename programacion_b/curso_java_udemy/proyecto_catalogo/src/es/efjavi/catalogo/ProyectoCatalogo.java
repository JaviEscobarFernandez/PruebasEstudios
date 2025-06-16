package es.efjavi.catalogo;

import es.efjavi.catalogo.producto.*;

import java.util.*;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];
        productos[0] = new Libro(16, new Date(1864, Calendar.NOVEMBER, 25), "Julio Verne", "Viaje al centro de la tierra", "Molino");
        productos[1] = new Comic(2, new Date(2025, Calendar.JUNE, 26), "Eric Gapstur, Christos Gage", "Tu amigo y vecino Spider-Man 1", "Marvel Comics", "Peter Parker");
        productos[2] = new Iphone(1219, "Apple", "iPhone 16 Pro", "Blanco");
        productos[3] = new TvLcd(559, "Samsung", 50);

        System.out.println("Imprimiendo productos: ");
        for (Producto p : productos) {
            System.out.println("====================================");
            System.out.println("Información del producto: ");
            System.out.println(p.toString());
            System.out.println("====================================");
            System.out.println();
        }
    }
}
