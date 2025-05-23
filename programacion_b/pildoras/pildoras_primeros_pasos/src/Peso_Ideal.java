
import javax.swing.*;

public class Peso_Ideal {

	public static void main(String[] args) {
		// Programa que pide la altura y calcula el peso ideal.
		
		String genero = "";
		do
		{
			genero = JOptionPane.showInputDialog("Introduce tu género (H/M)");
		}
		while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm por favor"));
		int peso_ideal = 0;
		if (genero.equalsIgnoreCase("H") == true)
			peso_ideal = altura - 110;
		else
			peso_ideal = altura - 120;
		
		System.out.println("Tu peso ideal es: " + peso_ideal + "kg.");
	}

}
