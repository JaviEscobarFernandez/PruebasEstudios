

public class Uso_Arrays {

	public static void main(String[] args) {
		// Prueba de arrays unidimensionales, utilizando el bucle for y el bucle foreach
		int[] vector = new int[5];
		for (int i = 0; i < vector.length; i++)
		{
			vector[i] = i+1;
			System.out.println("La posicion " + i + " del vector tiene valor: " + vector[i]);
		}
		
		int contador = 1;
		String[] paises = { "España", "Italia", "Francia", "Alemania", "Inglaterra", "Bélgica", "Portugal" };
		for (String pais : paises)
		{
			System.out.println(contador + " - " + pais);
			contador++;
		}
	}

}
