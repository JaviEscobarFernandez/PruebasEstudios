package videotutoria_02;

public class Gato extends Mascota {
	public Gato(String nombre, int edad, String color) {
		super(nombre, edad, color);
	}

	// Establecemos override para sobreescribir o reemplazar el metodo saludar de la superclase Mascota
	@Override
	public void saludar() {
		System.out.println("Miiiau. Me llamo " + getNombre() + " y tengo " + getEdad() + " años y soy de color " + getColor());
	}
}
