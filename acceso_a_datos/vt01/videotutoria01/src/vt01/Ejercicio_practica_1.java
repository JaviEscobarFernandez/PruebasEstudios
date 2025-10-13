package vt01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ejercicio practica videotutoria: Crea un fichero de texto (fichero_de_texto.txt)
 * en la ruta C:\AD\Ejercicios
 *
 * Ampliacion del ejercicio: Permitir que el usuario pueda elegir que hacer:
 * Crear un directorio llamado nuevoDirectorio en la ruta C:\AD\Ejercicios.
 * Crear un nuevo fichero de texto llamado fichero_de_texto2.txt en nuevoDirectorio.
 * Eliminar el fichero fichero_de_texto.txt
 * Eliminar el directorio nuevoDirectorio
 * Salir
 * Las opciones se pueden seguir eligiendo hasta que elusuario elija opcion Salir
 */
public class Ejercicio_practica_1 {

	private static final String RUTA = "C:\\AD\\Ejercicios";
	
	public static void main(String[] args) {
		File directorio = new File(RUTA);
		File fichero = new File(directorio, "fichero_de_texto.txt");
		try {
			directorio.mkdir();
			if (fichero.createNewFile())
				System.out.println("Fichero creado correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String opcion = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1 - Crear directorio con nombre nuevoDirectorio:");
			System.out.println("2 - Crear fichero con nombre fichero_de_texto2.txt en nuevoDirectorio:");
			System.out.println("3 - Eliminar fichero fichero_de_texto.txt:");
			System.out.println("4 - Eliminar el directorio nuevoDirectorio:");
			System.out.println("5 - Salir:");
			
			opcion = sc.nextLine();
			hacerAccion(opcion);
		} while (!opcion.contentEquals("5"));
		sc.close();
	}
	
	private static void hacerAccion(String opcion) {
		switch (opcion) {
			case "1":
				crearDirectorio();
				break;
			case "2":
				crearFichero();
				break;
			case "3":
				eliminarFichero();
				break;
			case "4":
				eliminarDirectorio();
				break;
			case "5":
				System.out.println("Finalizando...");
				break;
			default:
				System.err.println("ERROR: Dato introducido no válido, por favor, elige una opción del menú.");
		}
	}
	
	private static void crearDirectorio() {
		File directorio = new File(RUTA, "nuevoDirectorio");
		if (directorio.mkdir())
			System.out.println("Directorio " + directorio.getName() + " creado correctamente.");
		else
			System.err.println("ERROR: no se ha podido crear el directorio " + directorio.getName());
	}
	
	private static void crearFichero() {
		File fichero = new File(RUTA, "nuevoDirectorio/fichero_de_texto2.txt");
		try {
			if (fichero.createNewFile())
				System.out.println("Fichero " + fichero.getName() + " creado correctamente.");
			else
				System.err.println("ERROR: no se ha podido crear el fichero " + fichero.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void eliminarFichero() {
		File fichero = new File(RUTA, "fichero_de_texto.txt");
		if (fichero.delete())
			System.out.println("Fichero " + fichero.getName() + " borrado correctamente.");
		else
			System.err.println("ERROR: no se ha podido borrar el fichero " + fichero.getName());
	};

	private static void eliminarDirectorio() {
		File directorio = new File(RUTA, "nuevoDirectorio");
		if (directorio.delete())
			System.out.println("Directorio " + directorio.getName() + " borrado correctamente.");
		else
			System.out.println("ERROR: no se ha podido borrar el directorio " + directorio.getName());
	}
}
