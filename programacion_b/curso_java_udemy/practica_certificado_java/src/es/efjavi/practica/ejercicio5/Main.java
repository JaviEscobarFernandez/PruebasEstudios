package es.efjavi.practica.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        saludo();
        datosExpresiones();
        controlFlujo();
    }

    private static void saludo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);
    }

    private static void datosExpresiones() {
        int a = 10;
        boolean b = true;
        short s = 32767;
        byte x = 127;
        b = a < s && a < x;
        System.out.println(a + " es menor que " + s + " y menor que " + x + "? " + b);

        String valorA = Integer.toString(a);
        System.out.println(valorA);

        String num1 = "10";
        String num2 = "20";
        System.out.println("Concatenacion de " + num1 + " y " + num2 + ": " + num1 + num2);
        System.out.println("Suma de " + num1 + " y " + num2 + ": " + (Integer.parseInt(num1) + Integer.parseInt(num2)));

        String string1 = "Prueba";
        string1 = string1.substring(2, 4);
        System.out.println(string1);
        String string2 = new String("Test");
        string2.concat(string1);
        System.out.println("combinacion no asignada a la variable: " + string2);
        string2 = string2.concat(string1);
        System.out.println("combinacion asignada (ahora si) a la variable: " + string2);
        System.out.println("longitud de string2: " + string2.length());

        List<String> nombres = new ArrayList<>();
        nombres.add("Jose");
        nombres.add("Juan");
        nombres.add("Javi");
        nombres.add("Miguel");
        nombres.add("Aitor");
        nombres.add("Josefina");
        nombres.add("Alex");
        nombres.add("Guillermo");

        System.out.println("el nombre en la posicion 3 es: " + nombres.get(3));
        nombres.add(0, "Raquel");
        System.out.println("el primer nombre de la lista es: " + nombres.getFirst());
        System.out.println("El ultimo nombre de la lista es: " + nombres.getLast());

        System.out.println("\nRecorriendo la lista de nombres con for tradicional: ");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }

        System.out.println("\nRecorriendo la lista de nombres con foreach: ");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("\nRecorriendo la lista de nombres con codificacion moderna: ");
        nombres.forEach(System.out::println);

        System.out.println("\nRecorriendo la lista de nombres a la inversa: ");
        for (int i = nombres.size() - 1; i >= 0; i--) {
            System.out.println(nombres.get(i));
        }
    }

    private static void controlFlujo() {
        double notaExamen = 8.43;
        String nota;
        if (notaExamen >= 9)
            nota = "A";
        else if (notaExamen >= 7)
            nota = "B";
        else if (notaExamen >= 6)
            nota = "C";
        else if (notaExamen >= 5)
            nota = "D";
        else
            nota = "F";
        System.out.println("La calificacion del examen es: " + nota);

        System.out.println("Imprimiendo los numeros pares hasta el 20");
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }

        System.out.println("Cuenta regresiva con bucle while");
        int cont = 10;
        while (cont >= 0) {
            System.out.println(cont);
            cont--;
        }
    }
}
