

public class Arrays_Bidimensionales {

    public static void main(String[] args) {
    	// Programa para probar matrices o arrays bidimensionales

        int[][] matrix = new int[4][5];
        // Recorro toda la matriz para ir rellenando con valores
        int longitud_columnas = matrix[0].length;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < longitud_columnas; j++)
            {
                matrix[i][j] = i + j;
            }
        }

        // Probando a recorrer con foreach la matriz para imprimir los valores
        for (int[] fila : matrix)
        {
            for (int columna : fila)
            {
                System.out.print(columna + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }

        // Probando a inicializar la matriz directamente en la declaracion
        int[][] matrix_2 =
    	{
			{ 10, 20, 30, 40 },
			{ 15, 25, 35, 45 },
			{ 12, 22, 32, 42 },
			{ 11, 21, 31, 41 }
    	};

        // Recorremos de nuevo el array para imrpimir los valores
        for (int[] fila : matrix_2)
        {
            for (int columna : fila)
            {
                System.out.print(columna + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}
