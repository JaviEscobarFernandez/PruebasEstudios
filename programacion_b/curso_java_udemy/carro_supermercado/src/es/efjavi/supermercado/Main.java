package es.efjavi.supermercado;

import es.efjavi.supermercado.producto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BolsaSupermercado bolsaLacteos = new BolsaSupermercado();
        BolsaSupermercado bolsaFruta = new BolsaSupermercado();
        BolsaSupermercado bolsaLimpieza = new BolsaSupermercado();
        BolsaSupermercado bolsaNoPerecible = new BolsaSupermercado();

        bolsaLacteos.addProducto(new Lacteo("Yogurt", 2.34, 6, 340))
                .addProducto(new Lacteo("Leche Entera", 3.56, 6, 540))
                .addProducto(new Lacteo("Helado Nata Fresa", 4.56, 4, 324))
                .addProducto(new Lacteo("Cuajada", 5.64, 6, 602))
                .addProducto(new Lacteo("Batido Chocolate", 1.23, 1, 218));
        detalleBolsaTipoLacteo(bolsaLacteos.getProductos());

        bolsaFruta.addProducto(new Fruta("Manzana", 2.34, 300, "Rojo"))
                .addProducto(new Fruta("Plátano", 3.56, 500, "Amarillo"))
                .addProducto(new Fruta("Naranja", 4.56, 1000, "Naranja"))
                .addProducto(new Fruta("Sandía", 10.64, 2000, "Verde"))
                .addProducto(new Fruta("Fresa", 7.23, 340, "Rojo"));
        detalleBolsaTipoFruta(bolsaFruta.getProductos());

        bolsaLimpieza.addProducto(new Limpieza("Gel Lavavajillas Azul", 2.34, "Jabon y cosas", 1))
                .addProducto(new Limpieza("Detergente", 2.56, "Algo con cosas", 2))
                .addProducto(new Limpieza("Lejía Blanca", 4.56, "Lejía", 3))
                .addProducto(new Limpieza("Lejía Amarilla", 10.64, "Lejía", 1))
                .addProducto(new Limpieza("Gel Lavavajillas Verde", 7.23, "Jabón y cosas", 2));
        detalleBolsaTipoLimpieza(bolsaLimpieza.getProductos());

        bolsaNoPerecible.addProducto(new NoPerecible("Galletas", 2.34, 40, 156))
                .addProducto(new NoPerecible("Rosquilletas", 2.56, 5, 50))
                .addProducto(new NoPerecible("Bolsa Hielo", 1.56, 1, 3))
                .addProducto(new NoPerecible("Caramelo", 3.64, 250, 500))
                .addProducto(new NoPerecible("Sirope", 7.23, 500, 1089));
        detalleBolsaTipoNoPerecible(bolsaNoPerecible.getProductos());
    }

    private static void detalleBolsaTipoLacteo(List<? extends Lacteo> productos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Mostrar los productos de la Bolsa de lacteos:\n");
        sb.append("==================================\n");
        for (Lacteo l : productos) {
            sb.append("Nombre: ").append(l.getNombre()).append("\t")
                    .append("Precio: ").append(l.getPrecio()).append("€\t")
                    .append("Cantidad: ").append(l.getCantidad()).append("\t")
                    .append("Proteinas: ").append(l.getProteinas()).append("\n");
        }
        sb.append("==================================\n");
        System.out.println(sb);
    }

    private static void detalleBolsaTipoFruta(List<? extends Fruta> productos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Mostrar los productos de la Bolsa de Fruta:\n");
        sb.append("==================================\n");
        for (Fruta f : productos) {
            sb.append("Nombre: ").append(f.getNombre()).append("\t")
                    .append("Precio: ").append(f.getPrecio()).append("€\t")
                    .append("Color: ").append(f.getColor()).append("\t")
                    .append("Peso: ").append(f.getPeso()).append("\n");
        }
        sb.append("==================================\n");
        System.out.println(sb);
    }

    private static void detalleBolsaTipoLimpieza(List<? extends Limpieza> productos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Mostrar los productos de la Bolsa de Limpieza:\n");
        sb.append("==================================\n");
        for (Limpieza l : productos) {
            sb.append("Nombre: ").append(l.getNombre()).append("\t")
                    .append("Precio: ").append(l.getPrecio()).append("€\t")
                    .append("Litros: ").append(l.getLitros()).append("\t")
                    .append("Componentes: ").append(l.getComponentes()).append("\n");
        }
        sb.append("==================================\n");
        System.out.println(sb);
    }

    private static void detalleBolsaTipoNoPerecible(List<? extends NoPerecible> productos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Mostrar los productos de la Bolsa de NoPerecible:\n");
        sb.append("==================================\n");
        for (NoPerecible l : productos) {
            sb.append("Nombre: ").append(l.getNombre()).append("\t")
                    .append("Precio: ").append(l.getPrecio()).append("€\t")
                    .append("Calorias: ").append(l.getCalorias()).append("\t")
                    .append("Contenido: ").append(l.getContenido()).append("\n");
        }
        sb.append("==================================\n");
        System.out.println(sb);
    }
}
