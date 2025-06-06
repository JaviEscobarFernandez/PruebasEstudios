package introduccion;

import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el radio del circulo para calcular su area: ");
        double radio = validarDouble(sc.nextLine());
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área del circulo con radio " + radio + " es: " + area);
        sc.close();
    }

    private static double validarDouble(String d) {
        double num = 0;
        try {
            num = Double.parseDouble(d);
            if (num < 1.0) {
                System.err.println("ERROR: el valor debe ser minimo 1.0, estableciendo al valor por defecto 1.0");
                num = 1.0;
            }
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto 1.0");
            num = 1.0;
        }
        return num;
    }
}
