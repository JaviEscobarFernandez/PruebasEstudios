package vt01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Crear un menu para la gestion de ficheros y directorios con java.nio
 */
public class ejercicio_java_nio {

	private static Path currentDirectory;

	public static void main(String[] args) {
		currentDirectory = Paths.get("Ejercicio_java_nio");
		try {
			crearDirectorio(currentDirectory);
		} catch (IOException e) { }

		String option = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---------------------");
			System.out.println("1 - Crear Fichero");
			System.out.println("2 - Crear Directorio");
			System.out.println("3 - Copiar Fichero o Directorio");
			System.out.println("4 - Borrar Fichero o Directorio");
			System.out.println("5 - Mover Fichero o Directorio");
			System.out.println("6 - Escribir Fichero");
			System.out.println("7 - Leer Fichero");
			System.out.println("8 - Salir");

			option = sc.nextLine();
			String nombre = "";
			try {
				switch (option) {
					case "1":
						nombre = solicitarNombre(true, sc);
						crearFichero(nombre);
						break;
					case "2":
						nombre = solicitarNombre(false, sc);
						crearDirectorio(nombre);
						break;
					case "3":
						copiarFicheroDirectorio(solicitarOrigenDestino(true, sc), solicitarOrigenDestino(false, sc));
						break;
					case "4":
						nombre = solicitarNombre(false, sc);
						borrarFicheroDirectorio(nombre);
						break;
					case "5":
						moverFicheroDirectorio(solicitarOrigenDestino(true, sc), solicitarOrigenDestino(false, sc));
						break;
					case "6":
						nombre = solicitarNombre(false, sc);
						System.out.println("Introduce el texto a escribir en el fichero");
						String texto = sc.nextLine();
						escribirFichero(nombre, texto);
						break;
					case "7":
						nombre = solicitarNombre(false, sc);
						leerFichero(nombre);
						break;
					case "8":
						System.out.println("Finalizando...");
						break;
					default:
						System.err.println("ERROR: dato introducido no válido");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!option.equalsIgnoreCase("8"));

		sc.close();
	}

	private static String solicitarNombre(boolean fichero, Scanner sc) {
		String nombre = "";
		if (fichero)
			System.out.println("Introduce el nombre del fichero (incluida su extension)");
		else
			System.out.println("Introduce el nombre del directorio (puede contener subdirectorios)");
		nombre = sc.nextLine();
		return nombre;
	}

	private static String solicitarOrigenDestino(boolean origen, Scanner sc) {
		String nombre = "";
		if (origen)
			System.out.println("Introduce el nombre del origen");
		else
			System.out.println("Introduce el nombre del destino");
		nombre = sc.nextLine();
		return nombre;
	}

	private static void crearFichero(String nombre) throws IOException {
		Path fichero = Paths.get(currentDirectory.toString(), nombre);
		Files.createFile(fichero);
	}

	private static void crearDirectorio(String nombre) throws IOException {
		Path directorio = Paths.get(currentDirectory.toString(), nombre);
		crearDirectorio(directorio);
	}

	private static void crearDirectorio(Path directorio) throws IOException {
		currentDirectory = Files.createDirectories(directorio);
	}

	private static void copiarFicheroDirectorio(String nombreOrigen, String nombreDestino) throws IOException {
		Path origen = Paths.get(currentDirectory.toString(), nombreOrigen);
		Path destino = Paths.get(currentDirectory.toString(),nombreDestino);
		Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
	}

	private static void borrarFicheroDirectorio(String nombre) throws IOException {
		Path fichero = Paths.get(currentDirectory.toString(), nombre);
		Files.delete(fichero);
	}

	private static void moverFicheroDirectorio(String nombreOrigen, String nombreDestino) throws IOException {
		Path origen =  Paths.get(currentDirectory.toString(), nombreOrigen);
		Path destino =  Paths.get(currentDirectory.toString(), nombreDestino);
		Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
	}

	private static void escribirFichero(String nombre, String texto) throws IOException {
		Path fichero =  Paths.get(currentDirectory.toString(), nombre);
		Files.writeString(fichero, texto);
	}

	private static void leerFichero(String nombre) throws IOException {
		Path fichero =  Paths.get(currentDirectory.toString(), nombre);
		String texto = Files.readString(fichero);
		System.out.println(texto);
	}
}
