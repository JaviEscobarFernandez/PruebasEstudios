
import javax.swing.JOptionPane;

public class Comprueba_Mail {

	public static void main(String[] args) {
		// Programa para comprobar si la dirección e-mail es correcta. (tiene o no @)
		int caracter_arroba_cont = 0;
		boolean caracter_punto = false;
		String mail = JOptionPane.showInputDialog("Introduce tu e-mail");
		for (int i = 0; i < mail.length(); i++)
		{
			char caracter = mail.charAt(i);

			if (caracter == '@')
				caracter_arroba_cont++;

			if (!caracter_punto && caracter == '.')
				caracter_punto = true;				
		}

		if (caracter_arroba_cont == 1 && caracter_punto == true)
			System.out.println("El e-mail es correcto.");
		else
			System.out.println("ERROR: el e-mail introducido es incorrecto.");
	}

}
