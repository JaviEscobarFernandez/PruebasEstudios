package poo;

public interface Trabajadores {

	void setBonus(double bonus);
	// Creamos una constante para el bonus_base minimo
	// por defecto al declarar una variable en las interfaces
	// son public, static y final (constantes)
	// public static final double bonus = 1500.00;
	double bonus_base = 1500.00;
}
