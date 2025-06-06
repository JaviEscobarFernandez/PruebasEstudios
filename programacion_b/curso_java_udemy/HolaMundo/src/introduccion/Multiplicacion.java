package introduccion;

import java.util.Scanner;

public class Multiplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del primer numero:");
        int a = validarNumero(sc);
        System.out.println("Introduce el valor del segundo numero:");
        int b = validarNumero(sc);
        boolean positivo = (a > 0 && b > 0) || (a < 0 && b < 0);
        int result = 0;
        for (int i = 0; i < Math.abs(b); i++) {
            result += Math.abs(a);
        }
        if (!positivo)
            result = -(result);
        System.out.println("El resultado de multiplicar " + a + " por " + b + " es igual a: " + result);
        sc.close();
    }

    private static int validarNumero(Scanner sc) {
        int num = 0;
        try {
            String n = sc.nextLine();
            num = Integer.parseInt(n);
        } catch(Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto 1.");
            num = 1;
        }
        return num;
    }
}
