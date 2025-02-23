package videotutoria_02;

public class Mascota {
	// Atributos
	private String nombre;
	private int edad;
	private String color;

	// Constructor
	public Mascota(String n, int e, String c) {
		// Inicializar los atributos con los parametros recibidos
		this.nombre = n;
		this.edad = e;
		this.color = c;
	}

	// getters
	public String getNombre() { return nombre; }
	public int getEdad() { return edad; }
	public String getColor() { return color; }

	// setters
	public void saludar() {
		System.out.println("Hola, me llamo " + getNombre() + " y tengo " + getEdad() + " años y soy de color " + getColor());
	}
}
