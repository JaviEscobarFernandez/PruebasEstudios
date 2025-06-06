package introduccion;

import java.security.spec.RSAOtherPrimeInfo;

public class Caracteres {
    public static void main(String[] args) {
        char caracter = '\u0040';
        char decimal = 64;
        char simbolo = '@';
        System.out.println("caracter: " + caracter);
        System.out.println("decimal: " + decimal);
        System.out.println("decimal = caracter?? " + (decimal == caracter ? "verdadero" : "falso"));
        System.out.println("simbolo = caracter?? " + (simbolo == caracter ? "verdadero" : "falso"));

        System.out.println("tipo character en bytes: " + Character.BYTES);
        System.out.println("tipo character en bits: " + Character.SIZE);
        System.out.println("máximo valor typo character: " + Character.MAX_VALUE);
        System.out.println("mínimo valor typo character: " + Character.MIN_VALUE);

        char espacio = '\u0020';
        System.out.println("Imprimiendo 4 espacios:" + espacio + espacio + espacio + espacio + ".");
        char retroceso = '\b';
        System.out.println("Probando retroceso: " + retroceso + retroceso + retroceso);
        char tabulacion = '\t';
        System.out.println("Tabulando" + tabulacion + tabulacion + "2 veces.");
        char nuevaLinea = '\n';
        System.out.println("Probando salto de linea:" + nuevaLinea + "linea nueva.");
    }
}
