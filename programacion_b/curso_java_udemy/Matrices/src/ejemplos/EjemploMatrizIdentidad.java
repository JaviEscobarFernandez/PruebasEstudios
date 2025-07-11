package ejemplos;

public class EjemploMatrizIdentidad {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j)
                    matriz[i][j] = 1;
            }
        }

        for (int[] fila : matriz) {
            for (int col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
