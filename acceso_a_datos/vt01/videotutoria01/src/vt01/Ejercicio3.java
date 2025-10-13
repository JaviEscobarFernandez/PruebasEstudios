package vt01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 3: Crea un programa en Java que a partir de una cadena de caracteres,
 * permita almacenarlos en un fichero de texto
 * El programa añadirá un caracter * para indicar que ha llegado al final del fichero.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		String texto = "Cadena de caracteres a añadir al fichero";
		File directorio = new File("Ejercicio3");
		File fichero = new File(directorio, "fichero.txt");

		try {
			directorio.mkdir();
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println(e.toString());
		}

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
}
