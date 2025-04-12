package programacion_b_vt08_ejercicio_01;

import java.awt.EventQueue;

/*
 * Ejercicio 01 de la videotutoria 08
 * Crea un programa que muestre la interfaz de la imagen, y que cambie la pelicula dependiendo de la eleccion.
 */

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
