package introduccion;

import java.util.Scanner;

public class NotaFinal {
    public static void main(String[] args) {
        double[] notas = new double[20];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Introduce la nota numero " + (i + 1) + ":");
            notas[i] = validarNota(sc);
            if (notas[i] == 0) {
                System.err.println("ERROR: dato introducido no válido, finalizando el programa.");
                System.exit(1);
            }
        }
        double promedio5 = 0;
        double promedio4 = 0;
        int contNotas1 = 0;
        int contNotas4 = 0;
        int contNotas5 = 0;
        double promedioTotal = 0;
        for (double n : notas) {
            if (n > 5) {
                contNotas5++;
                promedio5 += n;
            }
            else if (n < 4) {
                contNotas4++;
                promedio4 += n;
                if (n <= 1)
                    contNotas1++;
            }
            promedioTotal += n;
        }
        promedioTotal = calcularPromedio(promedioTotal, notas.length);
        promedio5 = calcularPromedio(promedio5, contNotas5);
        promedio4 = calcularPromedio(promedio4, contNotas4);
        System.out.println("El promedio total de las notas es: " + promedioTotal);
        System.out.println("El promedio de notas mayores a 5 es: " + promedio5);
        System.out.println("El promedio de notas menores a 4 es: " + promedio4);
        System.out.println("El total de notas 1 o menores es: " + contNotas1);
        sc.close();
    }

    private static double validarNota(Scanner sc) {
        double nota = 0;
        try {
            String n = sc.nextLine();
            nota = Double.parseDouble(n);
            if (nota > 7) {
                System.err.println("ERROR: nota excede el valor 7, estableciendo valor 7 en la nota.");
                nota = 7;
            }
        } catch(Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto 1.");
            nota = 1;
        }
        return nota;
    }

    private static double calcularPromedio(double p, double c) {
        double promedio = p;
        if (c > 0)
            promedio = p / c;
        return promedio;
    }
}
