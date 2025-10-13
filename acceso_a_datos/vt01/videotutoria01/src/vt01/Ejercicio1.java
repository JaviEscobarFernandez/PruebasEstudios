package vt01;

import java.io.File;
import java.io.IOException;

/**
 * Propuesta Ejercicio 1: crear un directorio llamado miDirectorio
 * y dentro un archivo llamado miFichero.txt utilizando la clase File
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		// Creamos el directorio, utilizo ruta relativa
		File directorio = new File("./miDirectorio");
		if (directorio.mkdir())
			System.out.println("El directorio " + directorio.getName() + " ha sido creado correctamente");
		else
		{
			System.err.println("ERROR: No se ha podido crear el directorio, finalizando...");
			return;
		}
		
		// Creamos el fichero utilizando la ruta del directorio creado
		File fichero = new File(directorio, "miFichero.txt");
		try {
			if (fichero.createNewFile())
				System.out.println("El fichero " + fichero.getName() + " ha sido creado correctamente dentro de " + directorio.getName());
			else
				System.err.println("ERROR: No se ha podido crear el fichero, finalizando...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
