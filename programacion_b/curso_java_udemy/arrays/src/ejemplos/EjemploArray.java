package ejemplos;

import java.util.Arrays;
import java.util.Collections;

public class EjemploArray {
    public static void main(String[] args) {
        int[] numeros = new int[4];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        Arrays.sort(numeros);
        int numI = numeros[0];
        int numJ = numeros[1];
        int numK = numeros[2];
        int numL = numeros[3];
        // int numM = numeros[4];

        System.out.println("i = " + numI);
        System.out.println("j = " + numJ);
        System.out.println("k = " + numK);
        System.out.println("l = " + numL);

        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";

        Arrays.sort(productos);
        for (String s : productos) {
            System.out.println("producto = " + s);
        }
        System.out.println("productos[0] = " + productos[0]);

        for (int i = productos.length - 1; i >= 0; i--) {
            System.out.println("Producto[" + i + "] = " + productos[i]);
        }
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto[" + (productos.length - 1 - i) + "] = " + productos[productos.length - 1 - i]);
        }

        for (int i = 0; i < productos.length / 2; i++) {
            String actual = productos[i];
            String inverso = productos[productos.length - 1 - i];
            productos[i] = inverso;
            productos[productos.length - 1 - i] = actual;
        }
        for (String s : productos) {
            System.out.println("producto = " + s);
        }

        Collections.reverse(Arrays.asList(productos));
        for (String s : productos) {
            System.out.println("producto = " + s);
        }
    }
}
