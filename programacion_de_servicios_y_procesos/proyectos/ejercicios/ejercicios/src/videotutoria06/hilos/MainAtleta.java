package videotutoria06.hilos;

public class MainAtleta extends Thread {

    static void main() {
        System.out.println("¡Comienza la carrera!");
        Atleta[] atletas = new Atleta[10];

        for (int i = 0; i < atletas.length; i++) {
            atletas[i] = new Atleta("Atleta " + (i + 1));
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
        for (String a : Atleta.getClasificacion()) {
            System.out.println(++posicion + " - " + a);
        }
    }
}
