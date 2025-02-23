package tema6;

// clase Coche que hereda de la clase Vehiculo
public class Coche extends Vehiculo {
	// atributos especificos de Coche
	boolean climatizador;
	int numeroPuertas;

	// constructor
	public Coche(String color, String marca, String modelo) {
		super(color, marca, modelo);
		climatizador = false;
		numeroPuertas = 3;
	}

	// getters
	public boolean hasClimatizador() { return this.climatizador; }
	public int getNumeroPuertas() { return this.numeroPuertas; }

	// setters
	public void setClimatizador(boolean instalado) {
		climatizador = instalado;
	}
	public void setNumeroPuertas(int numero) {
		numeroPuertas = numero;
	}

	// metodos adicionales
	public void mostrarInfoCoche() {
		System.out.println("Mostrando información del coche:");
		System.out.println("Marca: " + getMarca());
		System.out.println("Modelo: " + getModelo());
		System.out.println("Color: " + getColor());
		System.out.println("Matricula: " + getMatricula());
		System.out.println("Con climatizador: " + (hasClimatizador() ? "Sí" : "No"));
		System.out.println("Total puertas: " + getNumeroPuertas());

	}
}
