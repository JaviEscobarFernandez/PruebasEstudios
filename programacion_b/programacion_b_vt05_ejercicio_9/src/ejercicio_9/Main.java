package ejercicio_9;

import java.util.Scanner;

/*
 * Crea una clase llamada Geometria e implementa en ella los siguientes metodos:
 * areaCuadrado(int lado): devolvera el area de un cuadrado (lado elevado a 2)
 * areaCirculo(int radio): devolvera el area de un circulo (2 x PI x radio)
 * areaTriangulo(int base, int altura): devolvera el area de un triangulo (base x altura)
 * Se debe solicitar al usuario 10 lados de cuadrados
 * Se debe solicitar al usuario 10 radios de circulos
 * Se debe solicitar al usuario 10 pares de base y altura de triangulos
 * Se deben guardar en un array los datos (bidimensional en el triangulo)
 * y recorrerlos para mostrar por consola el resultado
 */

public class Main {

    public static void main(String[] args) {
        // Lo realizo de forma modular y utilizando funcion estatica para calcular el area, para no instanciar cada figura geometrica
        Scanner sc = new Scanner(System.in);
        int[] ladoCuadrados = solicitarCuadrados(sc);
        int[] radioCirculos = solicitarCirculos(sc);
        int[][] datosTriangulo = solicitarTriangulos(sc);
        calcularAreaCuadrados(ladoCuadrados);
        calcularAreaCirculos(radioCirculos);
        calcularAreaTriangulos(datosTriangulo);
    }

    // Solicitamos al usuario 10 lados de los cuadrados y lo almacenamos en un vector que hemos creado.
    // Retornamos dicho vector con los lados establecidos en cada posicion.
    // Validamos el dato introducido por el usuario que sea adecuado para evitar errores.
    public static int[] solicitarCuadrados(Scanner sc) {
        int[] vector = new int[10];
        System.out.println("Vamos a calcular el area de 10 cuadrados:");
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Cuadrado " + (i + 1) + " - introduce la longitud de su lado: ");
            vector[i] = validarDatos(sc.nextLine());
        }
        return vector;
    }

    // Mostramos el resultado recorriendo el vector y utilizando la funcion para calcular su area
    public static void calcularAreaCuadrados(int[] vector) {
        int contador = 0;
        for (int i : vector) {
            ++contador;
            System.out.println("Cuadrado: " + contador + " - su area es: " + Geometria.areaCuadrado(i));
        }
    }

    // Solicitamos al usuario 10 radios de los circulos y lo almacenamos en un vector que hemos creado.
    // Retornamos dicho vector con los radios establecidos en cada posicion.
    // Validamos el dato introducido por el usuario que sea adecuado para evitar errores.
    public static int[] solicitarCirculos(Scanner sc) {
        int[] vector = new int[10];
        System.out.println("Vamos a calcular el area de 10 Circulos:");
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Circulo " + (i + 1) + " - introduce la longitud de su radio: ");
            vector[i] = validarDatos(sc.nextLine());
        }
        return vector;
    }

    // Mostramos el resultado recorriendo el vector y utilizando la funcion para calcular su area
    public static void calcularAreaCirculos(int[] vector) {
        int contador = 0;
        for (int i : vector) {
            ++contador;
            System.out.println("Circulo: " + contador + " - su area es: " + Geometria.areaCirculo(i));
        }
    }

    // Solicitamos al usuario 10 pares de base y altura de los triangulos y lo almacenamos en una matriz que hemos creado.
    // Retornamos dicha matriz con los pares de base y altura establecidos en cada posicion.
    // Validamos el dato introducido por el usuario que sea adecuado para evitar errores.
    public static int[][] solicitarTriangulos(Scanner sc) {
        int[][] matriz = new int[10][2];
        System.out.println("Vamos a calcular el area de 10 Triángulos:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Triángulo " + (i + 1) + " - introduce la longitud de su base: ");
            matriz[i][0] = validarDatos(sc.nextLine());
            System.out.println("Triángulo " + (i + 1) + " - introduce la longitud de su altura: ");
            matriz[i][1] = validarDatos(sc.nextLine());
        }
        return matriz;
    }

    // Mostramos el resultado recorriendo la matriz y utilizando la funcion para calcular su area
    public static void calcularAreaTriangulos(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            ++contador;
            System.out.println("Triángulo: " + contador + " - su area es: " + Geometria.areaTriangulo(matriz[i][0], matriz[i][1]));
        }
    }

    // Validamos el dato introducido, si es menor a 0 o no es un numero entero,
    // mostramos mensaje de error y establecemos valor 1 por defecto.
    public static int validarDatos(String datos) {
        int num = -1;

        try {
            num = Integer.parseInt(datos);
        }
        catch (Exception e) {
            num = -1;
        }

        if (num < 0) {
            System.out.println("Error, debes introducir un valor numérico mayor o igual a 0, lo establecemos a 1 por defecto.");
            num = 1;
        }
        return num;
    }
}
