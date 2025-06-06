package introduccion;

import java.util.Scanner;

public class OrdenMayor {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce el primer número: ");
            a = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduce el segundo número: ");
            b = sc.nextInt();
            System.out.println("Los números ordenados de mayor a menor son: " + ((a > b) ? a : b) + ", " + ((a > b) ? b : a));
        } catch(Exception e) {
            System.err.println("ERROR: Dato no admitido.");
        } finally {
            sc.close();
        }
    }
}
