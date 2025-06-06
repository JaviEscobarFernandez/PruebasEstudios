package ejemplos;

import java.util.Random;

public class ArrayMayorElemento {
    public static void main(String[] args) {
        int[] numeros = new int[7];
        Random rand = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(11, 100);
        }

        int max = 0;
        System.out.println("Imprimiendo la lista de números:");
        for (int i : numeros) {
            System.out.println("i = " + i);
            if (i > max) {
                max = i;
            }
        }
        System.out.println("El número más alto de la lista es: " + max);
    }
}
