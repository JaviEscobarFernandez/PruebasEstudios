package ejercicio_11;

/*
 * Crea una clase llamada MatrizAleatoria con un atributo que consista
 * en una matriz de enteros de 2 filas y 3 columnas.
 * Crea un metodo constructor que rellene la matriz de numeros aleatorios
 * Crea un metodo que imprima la matriz por consola.
 * Crea otro metodo que muestre, ademas de la matriz, junto a cada fila
 * y columna, el resultado de la suma de todos los numeros que la componen.
 * Comprueba desde el metodo main que funciona correctamente.
 */

public class Main {

    public static void main(String[] args) {
        MatrizAleatoria m = new MatrizAleatoria();
        m.mostrarMatriz();
        System.out.println();
        m.mostrarMatrizSuma();
    }

}
