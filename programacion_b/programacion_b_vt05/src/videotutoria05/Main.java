package videotutoria05;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        comprobarArrays();
        imprimirContenidoArrays();
        pruebaMatrizIrregular();
        pruebaStringMultivaluado();
        pruebaCastString();
        ejercicioArrayList();
        ejercicioLinkedList();
    }

    private static void comprobarArrays() {
        // 3 formas de declarar e inicializar los arrays.
        int[] enteros1 = { 1, 2, 3 };
        int[] enteros2 = new int[] { 1, 2, 3 };
        int[] enteros3 = new int[3];
        for (int i = 0; i < enteros3.length; i++)
            enteros3[i] = i + 1;

        // No son iguales porque esta comprobando la direccion en memoria del array, no su contenido
        System.out.println("Comprobando de forma erronea (direccion en memoria)");
        if (enteros1 == enteros3 || enteros1 == enteros2)
            System.out.println("Son iguales.");
        else
            System.out.println("No son iguales.");

        // Podemos comparar su contenido con el metodo estatico de la clase Array
        System.out.println("Comprobando de forma adecuada (su contenido)");
        if (Arrays.equals(enteros1, enteros2) || Arrays.equals(enteros1, enteros3))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");
    }

    private static void imprimirContenidoArrays() {
        int[] vector = { 1, 2, 3 };
        int[][] matriz = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };

        // Asi imprimimos la direccion de memoria
        System.out.println("Array1: " + vector.toString());
        // Si queremos imprimir todo su contenido debemos utilizar el metodo estatico de la clase Arrays
        System.out.println("Array1: " + Arrays.toString(vector));

        // Si intentamos imprimir el contenido de una matriz, nos va a imprimir la direccion de memoria de cada dimension
        System.out.println("Imprimiendo primera dimension: " + Arrays.toString(matriz));
        // Para imprimir el contenido de una matriz, debemos especificar que dimension imprimimos
        System.out.println("Imprimiendo primera dimension: " + Arrays.toString(matriz[0]));
        System.out.println("Imprimiendo segunda dimension: " + Arrays.toString(matriz[1]));
    }

    private static void pruebaMatrizIrregular() {
        // Declaramos e inicializamos una matriz, reservando unicamente la longitud de filas
        int[][] matrizIrregular = new int[3][];
        // las columnas deberan entonces declararse despues, pudiendo asignar a cada fila una longitud diferente.
        matrizIrregular[0] = new int[4];
        matrizIrregular[1] = new int[2];
        matrizIrregular[2] = new int[3];
        // Recorremos la matriz, primero por sus filas (la primera dimension) y luego por sus columnas irregulares
        for (int fila = 0; fila < matrizIrregular.length; fila ++) {
            for (int columna = 0; columna < matrizIrregular[fila].length; columna++) {
                // Rellenamos la matriz
                matrizIrregular[fila][columna] = 1 + fila + columna;
            }
        }
        // Volvemos a recorrer la matriz para imprimir su contenido.
        System.out.println("Reccoriendo matriz irregular con bucle for anidado e imprimiendo su contenido:");
        for (int fila = 0; fila < matrizIrregular.length; fila ++) {
            System.out.print("[ ");
            for (int columna = 0; columna < matrizIrregular[fila].length; columna++) {
                System.out.print(matrizIrregular[fila][columna] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        // Imprimir el contenido de la matriz sin recorrer con un for
        System.out.println("Imprimiendo el contenido de la matriz irregular con Arrays.toString():");
        for (int i = 0; i < matrizIrregular.length; i++) {
            System.out.println(Arrays.toString(matrizIrregular[i]));
        }
    }

    private static void pruebaStringMultivaluado() {
        // Prueba con campos multivaluados (malas practicas de BD)
        String telefonos = "912348321,664321903,619348210,693810394";
        // Creamos un array del string separados por comas, es decir,
        // trocea los caracteres del string hasta llegar a la coma y
        // lo almacena en una posicion del string
        String[] telefonosVector = telefonos.split(",");
        // Utilizamos un bucle foreach para recorrer el array
        // para imprimir cada numero por separado.
        int contador = 1;
        for (String i : telefonosVector) {
            System.out.println("Telefono " + contador + ": " + i);
            contador++;
        }
    }

    private static void pruebaCastString() {
        int num1 = 10;
        int num2 = 4;
        // Aqui realizamos un casting del int convirtiendolo en un string
        // por tanto al usar el + concatena ambos strings, en lugar de sumar sus valores.
        System.out.println("Concatenacion de enteros convertidos a string: " + (String.valueOf(num1) + String.valueOf(num2)));
        // Si lo hacemos con enteros, pues logicamente los suma
        System.out.println("Suma de enteros: " + (num1 + num2));
    }

    private static void ejercicioArrayList() {
        /*
         * Crea una clase Main donde se declare un ArrayList de caracteres.
         * Inserta tres caracteres: c, d y f. Imprime la lista por consola.
         * Añade los caracters a y b al principio de la lista e imprimela de nuevo.
         * Añade el caracter g al final de la lista. Imprime la lista de nuevo.
         * Añade un caracter e entre los caracteres d y f. Imprime la lista de nuevo.
         * Elimina el caracter de la posicion 3 (indice 2). Imprime la lista por consola.
         */
        ArrayList<Character> lista = new ArrayList<>();
        lista.add('c');
        lista.add('d');
        lista.add('f');
        System.out.println(lista);
        lista.addFirst('b'); // Añadimos al principio
        lista.addFirst('a'); // Añadimos al principio
        // Tambien lo podriamos añadir asi: (add no reemplaza, desplaza los existentes)
        // lista.add(0, 'a');
        // lista.add(1, 'b');
        System.out.println(lista);
        lista.add('g');
        System.out.println(lista);
        lista.add(2, 'e');
        System.out.println(lista);
        lista.remove(2);
        System.out.println(lista);
    }

    public static void ejercicioLinkedList() {
        /*
         * Crea una clase Main donde se declare un LinkedList de caracteres.
         * Inserta tres caracteres: c, d y f. Imprime la lista por consola.
         * Añade los caracters a y b al principio de la lista e imprimela de nuevo.
         * Añade el caracter g al final de la lista. Imprime la lista de nuevo.
         * Añade un caracter e entre los caracteres d y f. Imprime la lista de nuevo.
         * Elimina el caracter de la posicion 3 (indice 2). Imprime la lista por consola.
         */
        LinkedList<Character> lista = new LinkedList<>();
        lista.add('c');
        lista.add('d');
        lista.add('f');
        System.out.println(lista);
        lista.addFirst('b');
        lista.add(0,'a');
        System.out.println(lista);
        lista.add('g');
        System.out.println(lista);
        lista.add(2, 'e');
        System.out.println(lista);
        lista.remove(2);
        System.out.println(lista);
    }
}
