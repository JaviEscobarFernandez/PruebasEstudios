package ejemplos;

import java.util.Random;

public class ArrayHistograma {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numeros = new int[12];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(1, 7);
        }
        System.out.println("Imprimiendo lista de valores:");
        for (int i : numeros) {
            System.out.println("i = " + i);
        }

        System.out.println("Generando histograma:");
        int[] histograma = new int[6];
        for (int i = 0; i < histograma.length; i++) {
            for (int j : numeros) {
                if (i + 1 == j)
                    histograma[i] += 1;
            }
        }
        for (int i = 0; i < histograma.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < histograma[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
