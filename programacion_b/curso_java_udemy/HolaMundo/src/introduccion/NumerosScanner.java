package introduccion;

import javax.swing.*;
import java.util.Scanner;

public class NumerosScanner {
    public static void main(String[] args) {
        int numero = 500;
        System.out.println("Número decimal: " + numero);
        String resBinario = "El número binario de: " + numero + " es: " + Integer.toBinaryString(numero);
        System.out.println(resBinario);
        int numeroBinario = 0b111110100; // al empezar en 0b Java lo interpreta como binario convirtiendolo en decimal
        System.out.println("numeroBinario = " + numeroBinario);

        String resOctal = "El número octal de: " + numero + " es: " + Integer.toOctalString(numero);
        System.out.println(resOctal);
        int numeroOctal = 0764; // Si empieza en 0 Java lo interpreta como octal convirtiendolo en decimal
        System.out.println("numeroOctal = " + numeroOctal);

        String resHexadecimal = "El número hexadecimal de: " + numero + " es: " + Integer.toHexString(numero);
        System.out.println(resHexadecimal);
        int numeroHex = 0x1f4; // Si empieza en 0x Java lo interpreta como hexadecimal convirtiendolo en decimal
        System.out.println("numeroHex = " + numeroHex);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduce el numero deseado: ");
            String solicitarNumero = sc.nextLine();
            int numeroSolicitado = Integer.parseInt(solicitarNumero);
            System.out.println("El número introducido es: " + numeroSolicitado);
            String mensaje = resBinario + "\n" + resOctal + "\n" + resHexadecimal;
            System.out.print(mensaje);
        } catch (Exception e) {
            System.err.println("Error, dato introducido no válido.");
            System.err.println(e);
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
