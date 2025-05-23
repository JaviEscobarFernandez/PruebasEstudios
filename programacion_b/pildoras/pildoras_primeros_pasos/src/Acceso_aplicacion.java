
import javax.swing.*;

public class Acceso_aplicacion {

	public static void main(String[] args) {
		// Programa para probar bucle while, pide una contraseña y si coincide lo indica y finaliza, sino vuelve a preguntar.
		String clave = "1234";
		String pass = "";
		while(clave.equals(pass) == false)
		{
			pass = JOptionPane.showInputDialog("Introduce la contraseña");
			if (clave.equals(pass) == false)
				System.out.println("Contraseña incorrecta.");
		}
		System.out.println("Contraseña correcta, acceso permitido");
	}

}
