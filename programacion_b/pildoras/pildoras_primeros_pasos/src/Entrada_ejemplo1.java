
import java.util.*;

public class Entrada_ejemplo1 {
	public static void main(String[] args) {
		// Creamos un objeto scanner para manejar la consola de entrada.
		Scanner entrada = new Scanner(System.in);
		// Solicitamos que introduzca un nombre
		System.out.println("Introduce tu nombre: ");
		// Recogemos el nombre introducido.
		String nombre = entrada.nextLine();
		// Imprimimos el resultado y solicitamos su edad
		System.out.println("Hola " + nombre + ", introduce tu edad porfavor: ");
		// Recogemos la edad introducida
		int edad = entrada.nextInt();
		// Mostramos por pantalla todo.
		System.out.println("Genial " + nombre + " el año que viene tendrás " + (edad + 1) + " años.");
	}
}
