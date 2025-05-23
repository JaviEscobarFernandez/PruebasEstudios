
import javax.swing.*;
public class Uso_Bucle_For {

	public static void main(String[] args) {
		// Imprimir 10 veces nuestro nombre
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		for (int i = 0; i < 10; i++)
		{
			System.out.println((i+1) + " - " + nombre);
		}
	}

}
