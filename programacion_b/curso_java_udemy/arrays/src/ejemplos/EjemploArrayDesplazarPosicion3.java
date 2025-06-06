package ejemplos;

import java.util.Scanner;

public class EjemploArrayDesplazarPosicion3 {
    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        int numAdd, posAdd = 0;
        int total = a.length;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < total; i++) {
            if (i == total - 1) {
                a[i] = 0;
                continue;
            }
            System.out.print("Introduce el número: ");
            a[i] = validarNumero(sc.nextLine());
        }
        System.out.println("El orden inicial es: ");
        for (int i : a) {
            System.out.println("i = " + i);
        }

        System.out.println("Introduce un número a añadir a la lista: ");
        numAdd = validarNumero(sc.nextLine());

        for (int i = 0; i < total; i++) {
            if (numAdd > a[i] && (i + 1) < total && numAdd < a[i]) {
                posAdd = a[i + 1];
                break;
            }
            else if (numAdd < a[0]) {
                posAdd = a[0];
                break;
            }
        }

        for (int i = total - 1; i > posAdd; i--) {
            a[i] = a[i - 1];
        }
        a[posAdd] = numAdd;

        ordenarBuburja(a);
        System.out.println("El orden ahora es: ");
        for (int i : a) {
            System.out.println("i = " + i);

        sc.close();
        }
    }

    private static int validarNumero(String s) {
        int n = 0;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor 0 por defecto.");
        }
        return n;
    }

    private static void ordenarBuburja(Object[] array) {
        int total = array.length;
        int contador = 0;
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < (total - 1 - i); j++) {
                if (((Comparable)array[j + 1]).compareTo(array[j]) < 0) {
                    Object aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);
    }
}
