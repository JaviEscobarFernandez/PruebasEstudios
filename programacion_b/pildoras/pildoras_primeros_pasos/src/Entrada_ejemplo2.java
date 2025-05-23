
import javax.swing.*;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Por favor, introduce tu nombre: ");
		String edad = JOptionPane.showInputDialog("Por favor" + nombre + ", introduce tu edad: ");
		int edad_usuario = Integer.parseInt(edad);
		System.out.println("Hola " + nombre + ", tienes " + edad + " años.\nEl año que viene tendrás " + (edad_usuario + 1) + " años.");
	}

}
