package ejercicio_11;

import java.util.Random;

public class MatrizAleatoria {
    private int[][] randomMatriz = new int[2][3];

    public MatrizAleatoria() {
        Random randNumber = new Random();
        for (int i = 0; i < randomMatriz.length; i++) {
            for (int j = 0; j < randomMatriz[1].length; j++) {
                randomMatriz[i][j] = randNumber.nextInt(20);
            }
        }
    }

    public void mostrarMatriz() {
        System.out.println("Imprimiendo matriz normal: ");
        for (int i = 0; i < randomMatriz.length; i++) {
            for (int j = 0; j < randomMatriz[1].length; j++) {
                System.out.print("\t" + randomMatriz[i][j]);
            }
            System.out.println();
        }
    }

    public void mostrarMatrizSuma() {
        System.out.println("Imprimiendo matriz con sus sumas: ");
        int sumaCol0 = 0;
        int sumaCol1 = 0;
        int sumaCol2 = 0;
        int sumaTotal = 0;
        for (int i = 0; i < randomMatriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < randomMatriz[1].length; j++) {
                System.out.print("\t" + randomMatriz[i][j]);
                sumaFila += randomMatriz[i][j];
                sumaTotal += randomMatriz[i][j];
            }
            sumaCol0 += randomMatriz[i][0];
            sumaCol1 += randomMatriz[i][1];
            sumaCol2 += randomMatriz[i][2];
            System.out.print("\t | " + sumaFila);
            System.out.println("");
        }
        System.out.println("\t-------------------------|----");
        System.out.print("\t" + sumaCol0);
        System.out.print("\t" + sumaCol1);
        System.out.print("\t" + sumaCol2);
        System.out.print("\t | " + sumaTotal);

    }
}
