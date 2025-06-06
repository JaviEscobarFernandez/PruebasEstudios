package introduccion;

import java.util.Scanner;

public class NumeroMenor {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce el número en la posición " + (i + 1) + ":");
            numeros[i] = validarNumero(sc);
        }

        int min = numeros[0];
        for (int n : numeros) {
            if (n < min)
                min = n;
        }
        System.out.println("El número mínimo es: " + min);

        if (min < 10)
            System.out.println((min < 10) ? "El número menor es menor que 10!" : "El numero menor es igual o mayor que 10!");
        sc.close();
    }

    private static int validarNumero(Scanner sc) {
        int num = 0;
        try {
            String numero = sc.nextLine();
            num = Integer.parseInt(numero);
        } catch(Exception e) {
            System.out.println("ERROR: dato no válido, estableciendo valor por defecto 10.");
            num = 10;
        }
        return num;
    }
}
