
import javax.swing.*;

public class Entrada_numeros {

	public static void main(String[] args) {
		double x = 10000.0;
		// Imprimimos una division con todos los decimales
		System.out.println(x/3);
		// Aqui imprimimos con formato, para especificar con 2 decimales maximo
		System.out.printf("%1.2f", x/3);
		System.out.print("\n");
		
		// Probando parse
		String num1 = JOptionPane.showInputDialog("Introduce un número");
		double num2 = Double.parseDouble(num1);
		System.out.print("La raiz de " + num2 + " es: ");
		System.out.printf("%1.2f", Math.sqrt(num2));
	}

}
