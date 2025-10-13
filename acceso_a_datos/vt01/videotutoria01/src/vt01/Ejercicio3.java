package vt01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 3: Crea un programa en Java que a partir de una cadena de caracteres,
 * permita almacenarlos en un fichero de texto
 * El programa añadirá un caracter * para indicar que ha llegado al final del fichero.
 *
 * Variante: que almacene Strings a partir de un array de Strings
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		File directorio = new File("Ejercicio3");
		File fichero = new File(directorio, "fichero.txt");
		File fichero2 = new File(directorio, "fichero2.txt");

		try {
			directorio.mkdir();
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println(e.toString());
		}

		varianteUno(fichero);
		varianteDos(fichero2);
	}

	private static void varianteUno(File fichero) {
		String texto = "Cadena de caracteres a añadir al fichero";
		try {
			// Abrimos el flujo al fichero
			FileWriter fw = new FileWriter(fichero);

			// Escribimos en el fichero
			// fw.write(texto);
			// Lo hacemos caracter a caracter... por que no complicarnos...
			char[] cadena = texto.toCharArray();
			for (char c : cadena) {
				fw.write(c);
			}
			// Añadimos el caracter * al final del fichero
			fw.append('*');
			// Aplicamos los cambios en el fichero
			fw.flush();

			// Cerramos el flujo
			fw.close();
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

	private static void varianteDos(File fichero) {
		String[] textos = { "Texto array 1", "Texto array 2", "texto array 3", "Texto array 4" };
		try {
			// Abrimos el flujo al fichero
			FileWriter fw = new FileWriter(fichero);

			// Escribimos en el fichero
			for (String t : textos) {
				fw.write(t);
			}
			// Añadimos el caracter * al final del fichero
			fw.append('*');
			// Aplicamos los cambios en el fichero
			fw.flush();

			// Cerramos el flujo
			fw.close();
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}
}
