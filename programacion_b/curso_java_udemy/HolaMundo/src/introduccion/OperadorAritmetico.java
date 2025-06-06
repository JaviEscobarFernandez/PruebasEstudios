package introduccion;

import javax.swing.*;

public class OperadorAritmetico {
    public static void main(String[] args) {
        int a = 10;
        int b = 4;
        int suma = a + b;
        System.out.println("suma = " + suma);

        System.out.println("a + b = " + (a + b));

        int resta = a - b;
        System.out.println("resta = " + resta);
        System.out.println("a - b = " + (a - b));

        int multiplicacion = a * b;
        System.out.println("multiplicacion = " + multiplicacion);
        System.out.println("a * b = " + a * b);

        int division = a / b;
        System.out.println("division = " + division);
        System.out.println("a / b = " + a / b);

        int resto = a % b;
        System.out.println("resto = " + resto);
        System.out.println("a % b = " + a % b);

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero:"));
        if (numero % 2 == 0)
            System.out.println(numero + " es par");
        else
            System.out.println(numero + " es impar");
    }
}
