
import javax.swing.*;

public class Paises {

	public static void main(String[] args) {
		// Programa que pide por pantalla rellenar el vector con 8 paises y luego los muestra por pantalla.
		String[] vector_paises = new String[8];
		for (int i = 0; i < vector_paises.length; i++)
		{
			vector_paises[i] = JOptionPane.showInputDialog("Introduce el pais número " + (i + 1));
		}
		
		int contador = 1;
		for (String pais : vector_paises)
		{
			System.out.println(contador + " - " + pais);
			contador++;
		}
	}

}
