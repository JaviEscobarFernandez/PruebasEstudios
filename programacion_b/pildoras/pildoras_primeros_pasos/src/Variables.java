

public class Variables {

	public static void main(String[] args) {
		// Probando variables
		byte edad = 20;
		System.out.println("Edad inicial: " + edad);
		edad = 32;
		System.out.println("Edad actualizada: " + edad);
		// Probando constantes
		final int edadFija = 35;
		// edadFija = 40; (Ya no se puede editar)
		System.out.println("Edad fija invariable: " + edadFija);
		
		// Probando funcion
		System.out.println(sumar(edad, edadFija));
	}
	
	public static int sumar(int num1, int num2)
	{
		int resultado = num1 + num2;
		return resultado;
	}
}
