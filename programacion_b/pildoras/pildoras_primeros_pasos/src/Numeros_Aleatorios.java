

public class Numeros_Aleatorios {

	public static void main(String[] args) {
		/* 
		 * Programa que genera 150 numeros aleatorios
		 * los almacena y los muestra por pantalla
		 */
		int[] vector_random_num = new int[150];
		for (int i = 0; i < vector_random_num.length; i++)
		{
			vector_random_num[i] = (int)Math.round(Math.random() * 100);
		}
		
		int contador = 0; // Añadimos un contador para añadir un salto de linea cada 5 numeros
		for (int n : vector_random_num)
		{
			if (contador >= 5)
			{
				System.out.println("");
				contador = 0;
			}
			
			System.out.print(n + " ");
			contador++;
		}
	}

}
