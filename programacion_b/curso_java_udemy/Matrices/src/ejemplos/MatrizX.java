package ejemplos;

import java.util.Scanner;

public class MatrizX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la X: ");
        int size = validarSize(sc.nextLine());

        int[][] matrizX = new int[size][size];
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                if (i == j || (matrizX.length - i - 1) == j)
                    System.out.print("X");
                else
                    System.out.print("_");
            }
            System.out.println();
        }

        sc.close();
    }

    private static int validarSize(String s) {
        int n = 0;
        try {
            n = Integer.parseInt(s);
            if (n <= 0 || n > 10) {
                System.err.println("ERROR: debes introducir un número entero mayor a 0 y menor a 11");
                System.exit(1);
            }
        } catch (Exception e) {
                System.err.println("ERROR: dato introducido no válido");
                System.exit(1);
        }
        return n;
    }
}
