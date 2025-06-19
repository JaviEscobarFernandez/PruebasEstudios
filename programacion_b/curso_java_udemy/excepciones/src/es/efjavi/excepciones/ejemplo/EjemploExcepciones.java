package es.efjavi.excepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        String valor = JOptionPane.showInputDialog("Introduce un número:");
        String div = JOptionPane.showInputDialog("Introduce un divisor:");

        try {
            double division2 = calc.dividir(valor, div);
            System.out.println("division2 = " + division2);
        } catch (DivisionPorZeroException e) {
            System.err.println("Capturamos la excepcion en tiempo de ejecucion: " + e.getMessage());
            main(args);
        } catch (FormatoNumeroException e) {
            System.err.println("Detectada excepcion, introduce un valor numerico: " + e.getMessage());
            e.printStackTrace();
            main(args);
        } finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepcion.");
        }
        System.out.println("Continuamos el flujo de nuestra aplicación.");

    }
}
