package introduccion;

import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine(); // Introduciria Javi Escobar Fernandez
        System.out.println("¡Hola mundo soy " + nombre + "!");
        sc.close();
    }
}
