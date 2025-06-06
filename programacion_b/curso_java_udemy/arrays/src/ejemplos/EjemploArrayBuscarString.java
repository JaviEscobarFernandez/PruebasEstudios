package ejemplos;

import java.util.Scanner;

public class EjemploArrayBuscarString {
    public static void main(String[] args) {
        String[] a = new String[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.println("Introduce un nombre en posición " + (i + 1) + ":");
            a[i] = sc.nextLine();
        }

        System.out.println("Introduce un nombre a buscar en la lista:");
        String nombre = sc.nextLine();
        int pos = -1;
        int cont = 0;
        for (String s : a) {
            if (nombre.equalsIgnoreCase(s))
                pos = cont;
            cont++;
        }
        if (pos < 0)
            System.out.println("Lo siento ese nombre no esta en la lista.");
        else
            System.out.println("El nombre está en la posición de la lista: " + (pos + 1));
    }
}
