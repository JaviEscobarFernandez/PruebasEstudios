package videotutoria_02;

public class Perro extends Mascota {
	String raza;

	public Perro(String nombre, int edad, String color, String raza) {
		super(nombre, edad, color);
		this.raza = raza;
	}

	@Override
	public void saludar() {
		System.out.println("Guau, me llamo " + getNombre() + " y tengo " + getEdad() + " años," +
				" soy de raza " + getRaza() + " y soy de color " + getColor());
	}

	public String getRaza() { return raza; }
}
