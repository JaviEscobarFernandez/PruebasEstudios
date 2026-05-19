package videotutoria06.hilos;

public class MainAtletaRunnable {

    static void main() {
        System.out.println("¡Comienza la carrera!");
        Thread[] atletas = new Thread[10];

        for (int i = 0; i < atletas.length; i++) {
            AtletaRunnable atleta = new AtletaRunnable("Atleta " + (i + 1));
            atletas[i] = new Thread(atleta);
            atletas[i].start(); // los ejecutamos en paralelo con start (ejecutan internamente run en otro hilo)
        }

        try {
            // ponemos al main thread a la espera con join de que terminen todos los demas hilos su ejecucion
            for (Thread a : atletas) {
                a.join();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("La carrera ha finalizado");

        // mostrar la clasificacion
        System.out.println("Clasificación final:");
        int posicion = 0;
        for (String a : AtletaRunnable.getClasificacion()) {
            System.out.println(++posicion + " - " + a);
        }
    }
}
