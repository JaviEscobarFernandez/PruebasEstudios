package ejercicio_10;

import java.util.Scanner;

/*
 * Crea una clase llamada Empleado con atributos nombre (String) y sueldo (double).
 * Implementa el constructor y los getters y setters.
 * En el Main solicita al usuario que ingrese el nombre y el sueldo de 5 empleados,
 * instanciando sus objetos. Guarda cada objeto de la clase Empleado en un array.
 * Recorre el array buscando el empleado con mayor sueldo, e imprime por consola
 * el nombre y el sueldo de dicho empleado.
 */

public class Main {

    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[5];
        registrarEmpleados(empleados);

        double maxSueldo = 0;
        int empleadoTopPos = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getSueldo() > maxSueldo) {
                maxSueldo = empleados[i].getSueldo();
                empleadoTopPos = i;
            }
        }

        System.out.println("El empleado con mayor sueldo es: " + empleados[empleadoTopPos].getNombre() + " con un sueldo de: " + empleados[empleadoTopPos].getSueldo());
    }

    private static void registrarEmpleados(Empleado[] empleados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a registrar a 5 empleados:");
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Registrando el empleado número: " + (i + 1));
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce el sueldo: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            empleados[i] = new Empleado(nombre, sueldo);
        }
        sc.close();
    }
}
