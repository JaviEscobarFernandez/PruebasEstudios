package ejemplos;

import java.util.Scanner;

public class EjemploArrayDesplazarPosicion2 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int numAdd, posAdd;
        int total = a.length;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < total; i++) {
            if (i == total - 1) {
                a[i] = 0;
                continue;
            }
            System.out.print("Introduce el número: ");
            a[i] = validarNumero(sc.nextLine());
        }
        System.out.println("El orden inicial es: ");
        for (int i : a) {
            System.out.println("i = " + i);
        }

        System.out.println("Introduce un número a añadir a la lista: ");
        numAdd = validarNumero(sc.nextLine());
        System.out.println("Introduce una posición para añadir el número en la lista: (de 0 a 9)");
        posAdd = validarNumero(sc.nextLine());
        if (posAdd >= total || posAdd < 0) {
            System.err.println("ERROR: valor introducido no válido, estableciendo por defecto 0.");
            posAdd = 0;
        }
        for (int i = total - 1; i > posAdd; i--) {
            a[i] = a[i - 1];
        }
        a[posAdd] = numAdd;

        System.out.println("El orden ahora es: ");
        for (int i : a) {
            System.out.println("i = " + i);

        sc.close();
        }
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
