package es.efjave.poosobrecarga;

import static es.efjave.poosobrecarga.Calculadora.*;

public class EjemploSobrecarga {
    public static void main(String[] args) {
        System.out.println("suma int: " + sumar(10, 5));
        System.out.println("suma float " + sumar(10.f, 5.f));
        System.out.println("suma float-int: " + sumar(10.f, 5));
        System.out.println("suma int-float: " + sumar(10, 5.f));
        System.out.println("suma double: " + sumar(10.0, 5.0));
        System.out.println("suma string: " + sumar("10", "5"));
        System.out.println("sumar 3 int: " + sumar(10, 5, 30));

        System.out.println("suma long: " + sumar(10L, 5L));
        System.out.println("suma int-char: " + sumar(10, '@'));
        System.out.println("suma float-int(char): " + sumar(10.f, '@'));

        System.out.println("suma int variable: " + sumar(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("suma float variable: " + sumar(1.2f, 2.f, 3.f, 4.f, 5.f, 6.f, 7.f, 8.f, 9.f, 10.f));
        System.out.println("suma double variable: " + sumar(1.2, 2, 3, 4, 5, 6.0, 7, 8.0, 9.3, 10.5));
    }
}
