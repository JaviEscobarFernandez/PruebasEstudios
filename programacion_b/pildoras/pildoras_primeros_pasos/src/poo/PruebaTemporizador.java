package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class PruebaTemporizador {

	public static void main(String[] args) {

		System.out.println("Vamos a obtener la hora actual cada 5 segundos:");
		final int delay = 5000; // cada 5 segundos
		ObtenerHora listener = new ObtenerHora();
		Timer temporizador = new Timer(delay, listener);
		temporizador.start();

		// Utilizamos este metodo para mantener el temporizador en ejecucion.
		// Asi hasta que no cerremos la ventana seguira ejecutando el temporizador.
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para finalizar");
		// Una vez se cierre la ventana al darle a aceptar, finalizamos la ejecucion
		temporizador.stop();
		System.exit(0);
	}
}

// Clase que obtiene la interfaz ActionListener, para poder establecer el event en el temporizador
class ObtenerHora implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Date fechaActual = new Date();
		System.out.println("Hora actual: " + fechaActual);
	}
}
