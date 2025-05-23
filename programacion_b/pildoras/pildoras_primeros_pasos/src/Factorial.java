
import javax.swing.JOptionPane;

public class Factorial {

	public static void main(String[] args) {
		// Programa para calcular el factorial de un número
		
		int resultado = 1;
		int numero = 0;
		do
		{
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		}
		while (numero <= 0 || numero > 10);

		for (int i = numero; i > 0; i--)
		{
			resultado = resultado * i;
		}
		System.out.println("El factorial de " + numero + " es: " + resultado);
	}

}
