package videotutoria06.hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtletaRunnable implements Runnable {
    private String nombre;
    private int distancia;
    private static List<String> clasificacion = new ArrayList<>();

    public AtletaRunnable(String nombre) {
        this.nombre = nombre;
        this.distancia = 0;
    }

    public static List<String> getClasificacion() { return clasificacion; }

    public void run() {
        Random distanciaRand = new Random();
        int distanciaMeta = 100;

        while (distancia < distanciaMeta) {
            int metrosAvanzados = distanciaRand.nextInt(11); // entre 0 y 10 metros aleatoriamente
            distancia += metrosAvanzados;

            if (distancia >= distanciaMeta) {
                System.out.println("El corredor " + nombre + " ha cruzado la línea de meta");
                // envolvemos la lista en un bloque syncronized para bloquear el acceso concurrente y solo permitir un hilo al mismo tiempo
                synchronized (clasificacion) {
                    clasificacion.add(nombre);
                }
            }
            else
                System.out.println("El corredor " + nombre + " ha recorrido " + distancia + " metros");
        }
    }
}
