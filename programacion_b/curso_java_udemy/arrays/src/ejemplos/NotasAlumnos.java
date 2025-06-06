package ejemplos;

import java.util.Scanner;

public class NotasAlumnos {
    public static void main(String[] args) {
        final int TOTAL_ALUMNOS = 7;
        double[] claseMatematicas = new double[TOTAL_ALUMNOS];
        double[] claseHistoria = new double[TOTAL_ALUMNOS];
        double[] claseLenguaje = new double[TOTAL_ALUMNOS];
        double sumaNotasMates = 0, sumaNotasHistoria = 0, sumaNotasLengua = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce las notas de Matemáticas:");
        solicitarNotas(sc, claseMatematicas);
        System.out.println("Introduce las notas de Historia:");
        solicitarNotas(sc, claseHistoria);
        System.out.println("Introduce las notas de Lenguaje:");
        solicitarNotas(sc, claseLenguaje);

        for (int i = 0; i < TOTAL_ALUMNOS; i++) {
            sumaNotasMates += claseMatematicas[i];
            sumaNotasHistoria += claseHistoria[i];
            sumaNotasLengua += claseLenguaje[i];
        }

        double promedioMates = sumaNotasMates / claseMatematicas.length;
        double promedioHistoria = sumaNotasHistoria / claseHistoria.length;
        double promedioLengua = sumaNotasLengua / claseLenguaje.length;
        double promedioTotal = (promedioMates + promedioHistoria + promedioLengua) / 3;
        System.out.println("Promedio clase Matemáticas: " + promedioMates);
        System.out.println("Promedio clase Historia: " + promedioHistoria);
        System.out.println("Promedio clase Lenguaje: " + promedioLengua);
        System.out.println("Promedio total: " + promedioTotal);

        System.out.println("Introduce el identificador del alumno (de 1 a 7)");
        solicitarNotaAlumno(sc.nextLine(), claseMatematicas, claseHistoria, claseLenguaje);

        sc.close();
    }

    private static void solicitarNotas(Scanner sc, double[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
            notas[i] = validarNota(sc.nextLine());
        }
    }

    private static double validarNota(String n) {
        double nota = 0;
        try {
            nota = Double.parseDouble(n);
            if (nota < 0) {
                nota = 0;
                System.err.println("ERROR: Nota menor a 0, estableciendo valor a 0.");
            }
            if (nota > 10.00) {
                nota = 10.00;
                System.err.println("ERROR: Nota superior a 10, estableciendo valor a 10.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo valor por defecto en 0.");
        }
        return nota;
    }

    private static void solicitarNotaAlumno(String s, double[] mates, double[] historia, double[] lengua) {
        int id = 0;
        try {
            id = Integer.parseInt(s) - 1;
            if (id > 6 || id < 0) {
                id = 0;
                System.err.println("ERROR: id inválido, estableciendo por defecto 1");
            }
        } catch (Exception e) {
            System.err.println("ERROR: dato introducido no válido, estableciendo por defecto 1");
        }
        double promedioAlumno = (mates[id] + historia[id] + lengua[id]) / 3;
        System.out.println("El promedio del alumno con id: " + (id + 1) + " es: " + promedioAlumno);
    }
}
