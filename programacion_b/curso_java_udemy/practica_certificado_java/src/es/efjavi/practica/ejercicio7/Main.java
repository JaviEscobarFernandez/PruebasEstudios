package es.efjavi.practica.ejercicio7;

public class Main {
    public static void main(String[] args) {

        System.out.println(Calculadora.sumar(10, 45.2f));
        System.out.println(Calculadora.restar(134.3f, 123123123123d));
        System.out.println(Calculadora.multiplicar(12345679, 45));
        System.out.println(Calculadora.dividir(12.4f, 23.4));
        try {
            System.out.println(Calculadora.dividir(10, 0));
        } catch (DivisionPorCeroException e) {
            System.err.println(e);
        }
        System.out.println(Calculadora.dividir(10, 2));
    }
}
