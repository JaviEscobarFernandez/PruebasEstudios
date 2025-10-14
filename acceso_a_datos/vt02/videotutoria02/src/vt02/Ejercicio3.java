package vt02;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Ejercicio 3: Crea una excepcion personalizada llamada ArchivoNoEncontradoException
 * Que se lance cuando se intenta abrir un archivo que no existe.
 * PISTA: La excepcion personalizada se lanza dentro del bloque try-catch
 * y se maneja en el bloque catch correspondiente.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		try {
			leerArchivo("prueba_no_existe.txt");
		} catch (ArchivoNoEncontradoException e) {
			e.printStackTrace();
		}
	}

	private static void leerArchivo(String archivo) throws ArchivoNoEncontradoException {
		FileReader fr;
		try {
			fr = new FileReader("prueba_no_existe.txt");
		} catch (FileNotFoundException e) {
			throw new ArchivoNoEncontradoException("ERROR: No se ha localizado el fichero que se intenta abrir.");
		}
	}
}
