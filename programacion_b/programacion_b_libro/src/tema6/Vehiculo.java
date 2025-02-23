package tema6;

public class Vehiculo {
	// atributos base
	private String color;
	private String marca;
	private String modelo;
	private String matricula;
	private int velocidad;

	// Constructor
	public Vehiculo(String color, String marca, String modelo) {
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		velocidad = 0;
	}

	// getters
	public String getColor() { return this.color; }
	public String getMarca() { return this.marca; }
	public String getModelo() { return this.modelo; }
	public String getMatricula() { return this.matricula; }
	public int getVelocidad() { return this.velocidad; }

	// setters
	public void matricular(String matricula) {
		this.matricula = matricula;
	}
	public void pintar(String color) {
		this.color = color;
	}
	public void acelerar() {
		this.velocidad += 20;
	}
	public void frenar() {
		this.velocidad -= 20;
	}
}
