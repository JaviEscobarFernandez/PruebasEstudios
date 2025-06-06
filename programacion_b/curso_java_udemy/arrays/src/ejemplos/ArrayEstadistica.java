package ejemplos;

import java.util.Scanner;

public class ArrayEstadistica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[7];
        int total = numeros.length;
        int avgPositivo = 0, avgNegativo = 0, totalPositivo = 0, totalNegativo = 0, totalZero = 0;
        System.out.println("Introduce 7 números enteros:");
        for (int i = 0; i < total; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            numeros[i] = validarNumero(sc.nextLine());
        }

        System.out.println("Mostrando la lista de números:");
        for (int i : numeros) {
            System.out.println("i = " + i);
            if (i > 0) {
                totalPositivo++;
                avgPositivo += i;
            }
            else if (i < 0) {
                totalNegativo++;
                avgNegativo += Math.abs(i);
            }
            else
                totalZero++;
        }
        avgPositivo = avgPositivo / (totalPositivo > 0 ? totalPositivo : 1);
        System.out.println("El número total de números positivos es: " + totalPositivo + " con un promedio de: " + avgPositivo);
        avgNegativo = avgNegativo / (totalNegativo > 0 ? totalNegativo : 1);
        System.out.println("El número total de números negativos es: " + totalNegativo + " con un promedio de: " + (avgNegativo * -1));
        System.out.println("El número total de números con valor 0 es: " + totalZero);
        sc.close();
    }

    private static int validarNumero(String s) {
        int num = 0;
        try {
            num = Integer.parseInt((s));
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor 0 por defecto.");
            System.out.println("detalles del error: " + e);
        }
        return num;
    }
}
