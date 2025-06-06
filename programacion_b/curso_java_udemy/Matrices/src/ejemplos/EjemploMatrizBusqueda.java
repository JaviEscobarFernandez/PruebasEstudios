package ejemplos;

public class EjemploMatrizBusqueda {
    public static void main(String[] args) {
        int[][] matrizEnteros = {
            { 35, 90, 3, 1978       },
            { 15, 2025, 10, 5       },
            { 677, 127, 32767, 1999 },
        };

        int elementoBusqueda = 15;
        boolean found = false;
        int[] pos = new int[2];
        buscar: for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros[i].length; j++) {
                if (matrizEnteros[i][j] == elementoBusqueda) {
                    found = true;
                    pos[0] = i;
                    pos[1] = j;
                    break buscar;
                }
            }
        }

        if (found)
            System.out.println("Localizado el elemento: " + elementoBusqueda + " en la posición de la matriz: "
                    + "[" + pos[0] + "][" + pos[1] + "]");
    }
}
