package poo;

public class Coche {

	// atributos comunes del objeto
	private	int ruedas;
	private	int largo;
	private	int ancho;
	@SuppressWarnings("unused")
	private	int motor; // sin uso
	private	int peso_plataforma;
	private int precio;

	// atributos que pueden variar en el objeto
	private String color;
	private int peso_total;
	private boolean asientos_cuero;
	private boolean climatizador;
	
	// constructor (valores por defecto del objeto)
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}

	// Getters
	public String getDatosGenerales() {
		return "La plataforma del vehículo mide: " + getLargo() / 1000 + " metros.\n" +
		"La plataforma tiene una anchura de: " + ancho + " cm.\n" +
		"La plataforma tiene: " + ruedas + " ruedas y un peso de: " + peso_plataforma + " kilos.";
	}
	public int getLargo() { return largo; }
	public String getColor() { return color; }
	public String dime_color() {
		return "El color del vehículo es: " + getColor();
	}
	public String dime_asientos_cuero() {
		if (asientos_cuero)
			return "El vehículo tiene asientos de cuero.";
		return "El vehículo no tiene configurados asientos de cuero.";
	}
	public String dime_climatizador() {
		if (climatizador)
			return "El vehículo tiene climatizador.";
		return "El vehículo no tiene instalado el climatizador.";
	}
	public String dime_peso_total() {
		return "El peso total del vehículo es: " + peso_total + " kilos.";
	}
	public String dime_precio_final() {
		return "El precio final del vehículo es: " + precio + "€.";
	}

	// Setters
	public void setLargo(int longitud) { largo = longitud; }
	public void setColor(String nuevoColor) { color = nuevoColor; }
	public void setAsientos(boolean asientos_cuero) { this.asientos_cuero = asientos_cuero; }
	public void setClimatizador(boolean climatizador) { this.climatizador = climatizador; }
	public void setPesoTotal(int peso_carroceria) {
		// Peso del coche
		peso_total = peso_plataforma + peso_carroceria;
		// Peso por añadidos extras
		if (asientos_cuero)
			peso_total += 50;
		if (climatizador)
			peso_total += 20;
	}
	public void setPrecio(int precioBase) {
		// Precio inicial del coche
		precio = precioBase;
		// incremento del precio por añadidos extras
		if (asientos_cuero)
			precio += 2000;
		if (climatizador)
			precio += 1500;
	}
}
