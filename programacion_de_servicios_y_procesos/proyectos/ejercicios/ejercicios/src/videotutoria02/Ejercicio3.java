package videotutoria02;

// Prueba para comprobar el orden de ejecucion de los hilos
public class Ejercicio3 {
    static void main() {
        for (int i = 0; i < 5; i++) {
            HiloDos hilo = new HiloDos("H" + i);
            hilo.start();
        }
    }
}
