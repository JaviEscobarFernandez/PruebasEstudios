package ejemplos;

public class EjemploMatrizSumarFilaColumna {
    public static void main(String[] args) {
        int[][] a = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        int sumaFila = 0;
        int sumaColumna = 0;
        for (int i = 0; i < a.length; i++) {
            sumaFila = 0;
            sumaColumna = 0;
            for (int j = 0; j < a[i].length; j++) {
                sumaFila += a[i][j];
                sumaColumna += a[j][i];
            }
            System.out.println("La suma de la fila " + (i + 1) + " es: " + sumaFila);
            System.out.println("La suma de la columna " + (i + 1) + " es: " + sumaColumna);
        }
    }
}
