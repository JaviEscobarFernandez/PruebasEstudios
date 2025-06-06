package ejemplos;

public class EjemploMatrizTranspuesta {
    public static void main(String[] args) {
        int[][] matriz = {
            { 1,  2,  3,  4  },
            { 5,  6,  7,  8  },
            { 9,  10, 11, 12 },
            { 13, 14, 15, 16 }
        };

        System.out.println("Imprimiendo matriz: ");
        for (int[] fila : matriz) {
            for (int col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }

        int aux = 0;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
            }
        }

        System.out.println("Imprimiendo matriz transpuesta (invertir filas y columnas)");
        for (int[] fila : matriz) {
            for (int col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
