package poo;

public class Furgoneta extends Coche {

	private int capacidad_carga;
	private int plazas_extra;
	
	// constructor
	public Furgoneta(int plazas_extra, int carga) {
		
		super(); // llamar al constructor de la clase padre para establecer el estado inicial de los atributos comunes
		this.plazas_extra = plazas_extra;
		capacidad_carga = carga;
	}

	// getters
	public String dimeDatosFurgoneta() {
		
		return "La capacidad de carga es: " + capacidad_carga + " y con un total de plazas extra de: " + plazas_extra;
	}
}
