package videotutoria_02;

/*
 * Programa realizado en la videotutoria 02
 * Creamos una clase Mascota y las clases hijas perro y gato
 * Probamos en el metodo main a crear varios objetos y ejecutar algun metodo para imprimir los resultados.
 */

public class Main {

	public static void main(String[] args) {
		Mascota pececillo = new Mascota("Willy", 1, "Verde");
		pececillo.saludar();

		Gato gatico = new Gato("Simba", 4, "Negro");
		gatico.saludar();
		
		Perro perrico = new Perro("Rufo", 2, "Blanco", "Pointer");
		perrico.saludar();
	}

}
