package poo;

// Extendemos en la interfaz jefes la interfaz Trabajadores
public interface Jefes extends Trabajadores {

	// Si no se especifica public y abstract, en las interfaces por defecto tienen dichos modificadores
	// public abstract String tomarDecisiones(String decision);
	String tomarDecisiones(String decision);
}
