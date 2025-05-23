

public class Ejemplo_Array_2D {

	public static void main(String[] args) {
		/*
		 * Programa que crea una matriz y la rellenamos con un valor inicial en la primera fila
		 * Cada una de las columnas representa un incremento (del 10% al 15%) de interes
		 * Cada fila posterior incrementa ese interes al valor inicial en cada columna
		 */
		double acumulado = 0.0;
		double interes = 0.10;
		double[][] saldo = new double[5][6];
		for (int i = 0; i < saldo[0].length; i++)
		{
			saldo[0][i] = 10000.00;
			acumulado = 10000.00;
			for (int j = 1; j < saldo.length; j++)
			{
				acumulado += acumulado * interes;
				saldo[j][i] = acumulado;
			}
			interes += 0.01;
		}

		System.out.println("10%\t  |\t11%\t  |\t12%\t  |\t13%\t  |\t14%\t  |\t15%\t  |");
		System.out.println("-------------------------------------------------------------------------------------------");
		for (double[] fila : saldo)
		{
			for (double columna : fila)
			{
				System.out.printf("%1.2f", columna);
				System.out.print("€ |\t");
			}
			System.out.println("");
		}
	}
}
