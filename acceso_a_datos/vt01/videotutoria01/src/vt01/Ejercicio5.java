package vt01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ejercicio 5: Crear un fichero en Java que almacene en un fichero de texto
 * llamado Empleados.txt un listado con 5 empleados, indicando en cada linea
 * el ID y el nombre de cada empleado.
 *
 * A continuacion, el programa debe leer el contenido del fichero y mostrarlo por pantalla
 *
 * Nota: Los empleados y los Ids pueden ser introducidos desde el teclado o desde código.
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		File directorio = new File("Ejercicio5");
		File fichero = new File(directorio, "Empleados.txt");

		// Crear fichero
		try {
			directorio.mkdir();
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println(e.toString());
		}

		// insertar empleados
		try {
			insertarEmpleados(fichero);
			leerEmpleados(fichero);
		} catch (IOException e) {
			System.err.println(e.toString());
		}

	}

	private static void insertarEmpleados(File fichero) throws IOException {
		int cont = 1;
		Scanner sc = new Scanner(System.in);
		String nombre = "";

		// Solicitamos nombre e insertamos empleado en el fichero
		FileWriter fw = new FileWriter(fichero);
		while (cont <= 5) {
			System.out.println("Introduce el nombre del empleado número: " + cont);
			nombre = sc.nextLine();
			fw.write("ID: " + cont + " - " + nombre + "\n");
			fw.flush();
			cont++;
		}

		// Cerramos flujos
		fw.close();
		sc.close();
	}

	private static void leerEmpleados(File fichero) throws IOException {
		// Creamos el flujo, esta vez en un buffer, asi podemos leer linea a linea
		BufferedReader br = new BufferedReader(new FileReader(fichero));

		System.out.println("----------- LISTA DE EMPLEADOS -----------");
		// Leemos el fichero y mostramos el resultado
		String linea;
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
		}

		// Cerramos el flujo
		br.close();
	}
}
