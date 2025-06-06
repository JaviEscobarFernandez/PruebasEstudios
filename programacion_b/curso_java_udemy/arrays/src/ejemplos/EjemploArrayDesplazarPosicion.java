package ejemplos;

import java.util.Scanner;

public class EjemploArrayDesplazarPosicion {
    public static void main(String[] args) {
        int[] a = new int[10];
        int ultimo;
        int total = a.length;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < total; i++) {
            System.out.print("Introduce el número: ");
            a[i] = validarNumero(sc.nextLine());
        }
        System.out.println("El orden inicial es: ");
        for (int i : a) {
            System.out.println("i = " + i);
        }

        ultimo = a[total - 1];
        for (int i = (total - 2); i >= 0; i--) {
            a[i + 1] = a[i];
        }
        a[0] = ultimo;
        System.out.println("El orden ahora es: ");
        for (int i : a) {
            System.out.println("i = " + i);
        }

        sc.close();
    }

    private static int validarNumero(String s) {
        int n = 0;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor 0 por defecto.");
        }
        return n;
    }
}
