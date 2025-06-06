package ejemplos;

import java.util.Scanner;

public class EjemploArraysMayor {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 5 números enteros:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            a[i] = validarNumero(sc.nextLine());
        }

        int max = 0;
        for (int i : a) {
            if (i > max)
                max = i;
        }
        System.out.println("el número máximo es: " + max);
        sc.close();
    }

    private static int validarNumero(String s) {
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo por defecto 0");
        }

        return num;
    }
}
