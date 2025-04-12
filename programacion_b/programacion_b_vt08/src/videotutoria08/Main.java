package videotutoria08;

import java.awt.EventQueue;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal(); // Instanciamos la ventana
                    frame.setVisible(true); // La hacemos visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
