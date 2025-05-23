package poo;
import javax.swing.*;

public class UsoVehiculo {

	public static void main(String[] args) {

		// CrearCoche();
		PruebaHerenciaVehiculos();
	}

	static void CrearCoche() {
		// Probando a crear un Objeto de clase Coche y establecerle atributos utilizando getters y setters
		Coche Renault = new Coche(); // Instanciar una clase
		// imprimimos por consola los datos generales del coche
		System.out.println(Renault.getDatosGenerales());

		// Pedimos y establecemos el color del coche y lo imprimimos por consola
		Renault.setColor(JOptionPane.showInputDialog("Introduce el color del coche"));
		System.out.println(Renault.dime_color());

		// Pedimos y establecemos si incorporamos o no asientos de cuero y lo imprimimos por consola
		String respuesta = JOptionPane.showInputDialog("¿Le incorporamos asientos de cuero?");
		boolean asientosCuero = respuesta.equalsIgnoreCase("si");
		Renault.setAsientos(asientosCuero);
		System.out.println(Renault.dime_asientos_cuero());

		// Pedimos y establecemos si incorporamos o no climatizador y lo imprimimos por consola.
		respuesta = JOptionPane.showInputDialog("¿Le incorporamos climatizador?");
		boolean climatizador = respuesta.equalsIgnoreCase("si");
		Renault.setClimatizador(climatizador);
		System.out.println(Renault.dime_climatizador());

		// Establecemos el peso total del coche y lo imprimimos por consola.
		Renault.setPesoTotal(500);
		System.out.println(Renault.dime_peso_total());

		// Establecemos el precio final del coche y lo imprimimos por consola.
		Renault.setPrecio(10000);
		System.out.println(Renault.dime_precio_final());
	}

	static void PruebaHerenciaVehiculos() {
		// Probando la herencia, creamos un coche y luego probamos con una furgoneta, que hereda de la clase Coche
		Coche Ferrari = new Coche();
		Ferrari.setColor("Rojo");
		System.out.println(Ferrari.getDatosGenerales() + "\n" + Ferrari.dime_color());
		System.out.println();

		Furgoneta C15 = new Furgoneta(2, 380);
		C15.setColor("Plateado");
		C15.setAsientos(true);
		C15.setClimatizador(true);
		System.out.println(C15.getDatosGenerales() + "\n" + C15.dime_color());
		System.out.println(C15.dimeDatosFurgoneta());
	}
}
