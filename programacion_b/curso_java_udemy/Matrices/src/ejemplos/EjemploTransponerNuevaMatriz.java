package ejemplos;

public class EjemploTransponerNuevaMatriz {
    public static void main(String[] args) {
        int[][] a, b;
        a = new int[8][4];
        b = new int[4][8];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = i + j * 3;
        }

        System.out.println("Imprimiendo matriz original:");
        for (int[] fila : a) {
            for (int col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                b[j][i] = a[i][j];
        }

        System.out.println("Imprimiendo nueva matriz transpuesta:");
        for (int[] fila : b) {
            for (int col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
