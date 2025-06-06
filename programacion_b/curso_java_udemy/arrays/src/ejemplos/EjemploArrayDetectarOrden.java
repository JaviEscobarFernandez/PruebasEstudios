package ejemplos;

import java.util.Scanner;

public class EjemploArrayDetectarOrden {
    public static void main(String[] args) {
        int[] a = new int[7];
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 7 números enteros:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            a[i] = validarNumero(sc.nextLine());
        }

        boolean asc = false;
        boolean desc = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                desc = true;
            else if (a[i] < a[i + 1])
                asc = true;
        }

        if (asc && desc)
            System.out.println("La lista de números está desordenada.");
        else if (!asc && !desc)
            System.out.println("La lista tiene todos los valores iguales.");
        else if (asc && !desc)
            System.out.println("La lista está ordenada de forma ascendente.");
        else
            System.out.println("La lista está ordenada de forma descendente.");
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
