package cacl;

/*
 * Ejercicio propuesto en Videotutoria 03
 * Realizar una calculadora, con su clase, instanciarla y realizar unas operaciones.
 * Un solo atributo llamado numOperaciones que se incremente con cada operacion realizada.
 * Crear un metodo operacion que reciba dos parametros enteros y muestro su multiplicacion
 * Crear un metodo operacion que reciba tres parametros, dos numeros enteros y un String
 * Si el String es "sumar", que muestre la suma de los enteros
 * Si el String es "restar", que muestre la resta de los enteros
 * Tras cada operacion realizada, incrementar en 1 el valor de numOperaciones y mostrar el resultado y la cuenta de numOperaciones.
 */
public class Main {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		calculadora.operacion(1, 4);
		calculadora.operacion(1, 8, "sumar");
		calculadora.operacion(10, 2, "RESTAR");
		calculadora.operacion(3, 40, "Redondear");
	}
}
