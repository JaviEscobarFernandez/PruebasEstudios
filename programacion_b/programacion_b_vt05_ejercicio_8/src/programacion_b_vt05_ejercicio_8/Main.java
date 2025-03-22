package programacion_b_vt05_ejercicio_8;

import java.util.Scanner;

/*
 * Crea un ejercicio (con las clases que consideres necesarias) que pida al
 * usuario una cadena de caracteres y devuelva las siguientes operaciones
 * 1 - Mostrar el numero total de vocales
 * 2 - Invertir el String y mostrarlo por consola
 * 3 - Pedir un caracter al usuario y determinar el numero de
 *     apariciones que tiene dicho caracter en el String
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena de caracteres: ");
        String cadena = sc.nextLine();
        mostrarTotalVocales(cadena);
        mostrarInvertido(cadena);
        System.out.println();
        System.out.print("Introduce un caracter: ");
        String caracter = sc.nextLine();
        mostrarTotalCaracter(cadena, caracter);
        sc.close();
    }

    private static void mostrarTotalVocales(String s) {
        int total = 0;
        String stringLower = s.toLowerCase();
        char[] arrayChars = stringLower.toCharArray();
        for (char c : arrayChars) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                total++;
        }
        System.out.println("El número total de vocales es: " + total);
    }

    private static void mostrarInvertido(String s) {
        char[] arrayChars = s.toCharArray();
        System.out.println("La cadena al revés es:");
        for (int i = arrayChars.length - 1; i >= 0; i--) {
            System.out.print(arrayChars[i]);
        }
    }

    private static void mostrarTotalCaracter(String s, String c) {
        String stringLower = s.toLowerCase();
        char[] arrayChars = stringLower.toCharArray();
        String stringCharLower = c.toLowerCase();
        char[] arrayCharsC = stringCharLower.toCharArray();
        int total = 0;
        for (char i : arrayChars) {
            if (i == arrayCharsC[0])
                total++;
        }
        System.out.println("El número total de caracteres (" + arrayCharsC[0] + ") es de: " + total);
    }
}
