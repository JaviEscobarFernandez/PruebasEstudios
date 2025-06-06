package ejemplos;

import java.util.Scanner;

public class OrdenarArrayEspejo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int total = numeros.length;

        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < total; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            numeros[i] = validarNumero(sc.nextLine());
        }

        System.out.println("Mostrando la lista de números en orden espejo:");
        for (int i = 0; i < (total / 2); i++) {
            System.out.println(numeros[total - i - 1] + " - " + numeros[i]);
        }
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
