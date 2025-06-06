package ejemplos;

import java.util.Scanner;

public class MatrizSilla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la silla: ");
        int size = validarSize(sc.nextLine());

        boolean mitad = false;
        boolean masMitad = false;
        int[][] matrizH = new int[size][size];
        for (int i = 0; i < matrizH.length; i++) {
            mitad = matrizH.length / 2 == i;
            if (mitad && !masMitad)
                masMitad = true;
            for (int j = 0; j < matrizH[i].length; j++) {
                if (j == 0 || (mitad) || (masMitad && j == matrizH[i].length - 1))
                    matrizH[i][j] = 1;
                else
                    matrizH[i][j] = 0;
            }
            System.out.println();
        }
        for (int[] fila : matrizH) {
            for (int col : fila) {
                System.out.print(col);
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
