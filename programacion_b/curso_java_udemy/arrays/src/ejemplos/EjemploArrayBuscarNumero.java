package ejemplos;

import java.util.Scanner;

public class EjemploArrayBuscarNumero {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.println("Introduce un número en posición " + (i + 1) + ":");
            a[i] = validarNumero(sc.nextLine());
        }

        System.out.println("Introduce un número a buscar en la lista:");
        int num = validarNumero(sc.nextLine());
        int pos = -1;
        int cont = 0;
        for (int i : a) {
            if (num == i)
                pos = cont;
            cont++;
        }
        if (pos < 0)
            System.out.println("Lo siento ese número no esta en la lista.");
        else
            System.out.println("El número está en la posición de la lista: " + (pos + 1));
    }

    private static int validarNumero(String s) {
        int n = 0;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido.");
        }
        return n;
    }
}
