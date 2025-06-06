package ejemplos;

import java.util.Scanner;

public class EjemploArrayEliminarElemento {
    public static void main(String[] args) {
        int[] elementos = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int total = elementos.length;

        System.out.println("Mostrando lista de elementos:");
        for (int i : elementos) {
            System.out.println("i = " + i);
        }
        System.out.println("Introduce el elemento que quieres eliminar: ");
        Scanner sc = new Scanner(System.in);
        int delElemento = validarElemento(sc.nextLine());
        int delPos = -1;
        for (int i = 0; i < total; i++) {
            if (delElemento == elementos[i])
                delPos = i;
        }
        if (delPos < 1) {
            System.out.println("No se ha encontrado ningún elemento que coincida.");
            System.exit(1);
        }

        int[] elementos2 = new int[total - 1];
        int aux = 0;
        for (int i = 0; i < total; i++) {
            if (i == delPos)
                continue;
            elementos2[aux++] = elementos[i];
        }
        System.out.println("Mostrando lista de elementos actualizada:");
        for (int i : elementos2) {
            System.out.println("i = " + i);
        }
    }

    private static int validarElemento(String s) {
        int num = 0;
        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto 0.");
        }
        return num;
    }
}
