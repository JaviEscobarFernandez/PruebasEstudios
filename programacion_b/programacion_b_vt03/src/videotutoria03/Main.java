package videotutoria03;

/*
 * Ejercicio Videotutoria 03 realizado en clase, para probar un poco la POO basica
 */
public class Main {

	public static void main(String[] args) {
		Persona virginia = new Persona("Virginia", "Fernández", "López", 'F', 25, "Calle Mayor 4"); 
		virginia.mostrarDatos();
		virginia.mayorEdad();
	}

}
