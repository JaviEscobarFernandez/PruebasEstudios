package introduccion;

import java.util.Date;
import java.util.Scanner;

public class CalcularEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu fecha de nacimiento: (formato: dd/MM/yyyy) ");
        Date fechaNacimiento = new Date(sc.nextLine());
        Date fechaActual = new Date();
        long diff = fechaActual.getTime() - fechaNacimiento.getTime();
        long year = diff / (1000L * 60L * 60L * 24L * 30L * 12L);
        System.out.println("Tienes " + year + " años.");
    }
}
