package tema6;

/*
 * Programa que crea un objeto de tipo Coche, le establece una serie de caracteristicas
 * y lo pone a prueba con pruebas de velocidad basicas.
 */
public class Main {

	public static void main(String[] args) {
		// Creamos un objeto Coche
		Coche renault11 = crearCoche("Azul", "Renault", "11");
		renault11.setClimatizador(true);
		renault11.setNumeroPuertas(5);

		// Lo matriculamos
		renault11.matricular("1234 XDM");
		System.out.println(renault11.getMarca() + " " + renault11.getModelo() +
				" con color: " + renault11.getColor() + " matriculado con matricula: " + renault11.getMatricula());

		// Lo pintamos
		renault11.pintar("Blanco");
		System.out.println(renault11.getMarca() + " " + renault11.getModelo() +
				" con matricula: " + renault11.getMatricula() + " pintado con color: " + renault11.getColor());

		// Mostramos la informacion del coche
		renault11.mostrarInfoCoche();

		// Realizamos las pruebas de velocidad basicas
		probarCoche(renault11);
	}

	// metodos adicionales
	private static Coche crearCoche(String color, String marca, String modelo) {
		Coche c = new Coche(color, marca, modelo);
		System.out.println(marca + " " + modelo + " con color: " + color + " creado.");
		return c;
	}
	private static void probarCoche(Coche c) {
		System.out.println("Realizando pruebas al vehiculo: " + c.getMarca() + " " + c.getModelo());
		c.acelerar();
		mostrarVelocidad(c);
		c.acelerar();
		mostrarVelocidad(c);
		c.frenar();
		c.frenar();
		mostrarVelocidad(c);
		System.out.println("Pruebas finalizadas satisfactoriamente.");
	}
	private static void mostrarVelocidad(Coche c) {
		System.out.println("La velocidad del vehiclo es: " + c.getVelocidad());
	}
}
