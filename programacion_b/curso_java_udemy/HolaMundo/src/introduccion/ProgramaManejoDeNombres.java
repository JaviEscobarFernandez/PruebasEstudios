package introduccion;

import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre1 = "";
        String nombre2 = "";
        String nombre3 = "";
        System.out.println("Introduce el nombre del primer familiar: ");
        nombre1 = sc.nextLine();
        System.out.println("Introduce el nombre del segundo familiar: ");
        nombre2 = sc.nextLine();
        System.out.println("Introduce el nombre del tercer familiar: ");
        nombre3 = sc.nextLine();

        String nombre1Conv = aplicarConversion(nombre1);
        System.out.println("nombre1Conv = " + nombre1Conv);
        String nombre2Conv = aplicarConversion(nombre2);
        System.out.println("nombre1Conv = " + nombre2Conv);
        String nombre3Conv = aplicarConversion(nombre3);
        System.out.println("nombre1Conv = " + nombre3Conv);

        String nombreConc = nombre1Conv + "_" + nombre2Conv + "_" + nombre3Conv;
        System.out.println(nombreConc);
    }

    private static String aplicarConversion(String s) {
        String conv = s.substring(1, 2).toUpperCase();
        conv = conv.concat(".");
        conv = conv.concat(s.substring(s.length() - 2, s.length()));
        return conv;
    }
}
