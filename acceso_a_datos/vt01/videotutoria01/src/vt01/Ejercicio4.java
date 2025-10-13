package vt01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 4: Leer el fichero creado en el Ejercicio 3 y mostrarlo por consola.
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		File fichero = new File("Ejercicio3" + File.separator + "fichero.txt");

		try {
			int c = 0;
			// Abrimos el flujo al fichero
			FileReader fr = new FileReader(fichero);

			// Leemos el fichero caracter a caracter
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);
			}

			// Cerramos el flujo
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
