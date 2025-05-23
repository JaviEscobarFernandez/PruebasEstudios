

public class Calculos_con_math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double raiz = Math.sqrt(14);
		System.out.println("La raiz cuadrada es: " + raiz);
		// Vamos a redondear el resultado:
		int resultado_raiz = (int)Math.round(raiz); // Conversion implicita de long a int para poder almacenarlo
		System.out.println("Redondeando sería: " + resultado_raiz);
		
		// Potencia
		double base = 5;
		double exponente = 3;
		int resultado_potencia = (int)Math.pow(base, exponente);
		System.out.println("La potencia con base: " + base + " y exponente: " + exponente + " es: " + resultado_potencia);
	}
}
