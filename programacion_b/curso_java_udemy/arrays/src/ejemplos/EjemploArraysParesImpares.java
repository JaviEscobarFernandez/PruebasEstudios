package ejemplos;

import java.util.Scanner;

public class EjemploArraysParesImpares {
    public static void main(String[] args) {
        int[] a, pares, impares;
        a = new int[10];
        int totalPares = 0, totalImpares = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Número " + ( i + 1) + ": ");
            a[i] = validarNumero(sc.nextLine());
            System.out.println("");
        }

        totalPares = contarParesImpares(a, true);
        totalImpares = contarParesImpares(a, false);
        System.out.println("El número total de pares es: " + totalPares);
        System.out.println("El número total de impares es: " + totalImpares);

        pares = new int[totalPares];
        impares = new int[totalImpares];

        int auxPar = 0;
        int auxImpar = 0;
        for (int i : a) {
            if (i % 2 == 0)
                pares[auxPar++] = i;
            else
                impares[auxImpar++] = i;
        }
        System.out.println("Imprimiendo los pares:");
        for (int i : pares) {
            System.out.print(i + " ");
        }
        System.out.println("\nImprimiendo los impares:");
        for (int i : impares) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    private static int validarNumero(String n) {
        int num = 0;
        try {
            num = Integer.parseInt(n);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto 0.");
        }
        return num;
    }

    public static int contarParesImpares(int[] a, boolean par) {
        int cont = 0;
        for (int i : a) {
            if (i % 2 == 0 && par)
                cont++;
            else if (i % 2 != 0 && !par)
                cont++;
        }
        return cont;
    }

}
