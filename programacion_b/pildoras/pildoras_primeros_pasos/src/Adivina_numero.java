
import java.util.*;

public class Adivina_numero {

	public static void main(String[] args) {
		// Programa para generar un número aleatorio y pedir al usuario que lo adivine
		Scanner entrada = new Scanner(System.in);
		int aleatorio = (int)(Math.random() * 100);
		int numero = 0;
		int intentos = 0;
		do
		{
			System.out.print("Introduce un número de 0 a 100: " );
			numero = entrada.nextInt();
			if (numero != aleatorio)
			{
				intentos++;
				if (numero < aleatorio)
					System.out.println("El número introducido es menor.");
				else
					System.out.println("El número introducido es mayor.");

				System.out.println("Sigue probando");
			}
		}
		while (numero != aleatorio);
		System.out.println("Correcto, has adivinado el número en " + intentos + " intentos.");
	}

}
