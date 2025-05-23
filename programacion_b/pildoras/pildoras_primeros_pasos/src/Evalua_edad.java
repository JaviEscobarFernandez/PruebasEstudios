
import java.util.*;

public class Evalua_edad {

	public static void main(String[] args) {
		// Programa para provar condicional if/else if/else para valorar la edad.
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce tu edad: ");
		int edad = entrada.nextInt();
		if (edad < 18)
			System.out.println("Eres un adolescente.");
		else if (edad < 40)
			System.out.println("Eres joven");
		else if (edad < 65)
			System.out.println("Eres maduro.");
		else
			System.out.println("Cuidate.");
	}

}
