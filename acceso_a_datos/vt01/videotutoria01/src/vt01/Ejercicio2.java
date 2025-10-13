package vt01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 2: Crea un programa en Java que escriba y lea de un fichero de texto (datos.txt)
 * datos.txt estará en la carpeta que ya esta creada;
 * El programa tiene que mostrar el contenido de datos por consola.
 * Utilizando las clases FileReader y FileWriter.
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		File directorio = new File("Ejercicio2");
		directorio.mkdir();

		File fichero = new File(directorio, "datos.txt");
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println(e.toString());
		}

		try {
			escribirFichero(fichero);
			leerFichero(fichero);
		} catch (IOException e) {
			System.err.println("ERROR: " + e.toString());
		}
	}

	private static void escribirFichero(File fichero) throws IOException {
		// Abrimos flujo al fichero
		FileWriter wt = new FileWriter(fichero);

		// Introducimos el texto en el fichero
		String texto = "Hola, que tal, estoy introduciendo una línea.\n";
		wt.write(texto);
		String texto2 = "Esto es una nueva línea.\n";
		wt.append(texto2);

		// Aplicamos los cambios
		wt.flush();

		// Cerramos el flujo una vez finalizamos
		wt.close();
	}

	private static void leerFichero(File fichero) throws IOException {
		// Abrimos el flujo al fichero
		FileReader rd = new FileReader(fichero);

		// Leemos el fichero e imprimimos el resultado
		int c;
		while ((c = rd.read()) != -1)
			System.out.print((char)c);

		// Cerramos el flujo
		rd.close();
	}
}
