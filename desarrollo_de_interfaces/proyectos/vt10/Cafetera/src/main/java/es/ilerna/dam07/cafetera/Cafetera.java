
package es.ilerna.dam07.cafetera;

/**
 * Clase que representa una cafetera simple.
 * Permite preparar café, rellenarla con agua y vaciarla.
 * 
 * <p>Esta clase puede servir como ejemplo básico de cómo utilizar Javadoc.</p>
 * 
 * @author Ruben Merin
 * @version 1.0
 * @since 2025
 */
public class Cafetera {

    /** Capacidad máxima de la cafetera en mililitros. */
    private final int capacidadMaxima;

    /** Cantidad actual de agua en la cafetera en mililitros. */
    private int cantidadActual;

    /**
     * Constructor que inicializa la cafetera con una capacidad específica.
     * 
     * @param capacidadMaxima Capacidad máxima de la cafetera en mililitros.
     */
    public Cafetera(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = 0; // La cafetera empieza vacía.
    }

    /**
     * Prepara una taza de café si hay suficiente agua.
     * 
     * @param mililitros Cantidad de agua necesaria para preparar el café.
     * @return {@code true} si se pudo preparar el café, {@code false} si no hay suficiente agua.
     */
    public boolean prepararCafe(int mililitros) {
        if (cantidadActual >= mililitros) {
            cantidadActual -= mililitros;
            System.out.println("Café preparado con " + mililitros + " ml de agua.");
            return true;
        } else {
            System.out.println("No hay suficiente agua para preparar el café.");
            return false;
        }
    }

    /**
     * Rellena la cafetera hasta su capacidad máxima.
     */
    public void rellenar() {
        cantidadActual = capacidadMaxima;
        System.out.println("La cafetera ha sido rellenada.");
    }

    /**
     * Vacía toda el agua de la cafetera.
     */
    public void vaciar() {
        cantidadActual = 0;
        System.out.println("La cafetera ha sido vaciada.");
    }

    /**
     * Obtiene la cantidad actual de agua en la cafetera.
     * 
     * @return Cantidad de agua en mililitros.
     */
    public int getCantidadActual() {
        return cantidadActual;
    }

    /**
     * Obtiene la capacidad máxima de la cafetera.
     * 
     * @return Capacidad máxima en mililitros.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Indica si la cafetera está vacía.
     * 
     * @return {@code true} si la cafetera está vacía, {@code false} en caso contrario.
     */
    public boolean estaVacia() {
        return cantidadActual == 0;
    }

    /**
     * Indica si la cafetera está llena.
     * 
     * @return {@code true} si la cafetera está llena, {@code false} en caso contrario.
     */
    public boolean estaLlena() {
        return cantidadActual == capacidadMaxima;
    }
}

