package cacl;

public class Calculadora {
	private static int numOperaciones;

	public Calculadora() {
		numOperaciones = 0;
	}

	private void getNumOperaciones() {
		System.out.println("La calculadora ha realizado: " + numOperaciones + " operaciones.");
	}

	private void incrementNumOperaciones() {
		++numOperaciones;
		getNumOperaciones();
	}

	public void operacion(int num1, int num2) {
		System.out.println("La multiplicación de: " + num1 + " y " + num2 + " es: " + (num1 * num2));
		incrementNumOperaciones();
	}

	public void operacion(int num1, int num2, String o) {
		String op = o.toLowerCase();
		if (op.equals("sumar")) {
			System.out.println("La suma de: " + num1 + " y " + num2 + " es: " + (num1 + num2));
			incrementNumOperaciones();
		}
		else if (op.equals("restar")) {
			System.out.println("La resta de: " + num1 + " y " + num2 + " es: " + (num1 - num2));
			incrementNumOperaciones();
		}
		else {
			System.out.println("Error, operacion no válida");
		}
	}
}
