package videotutoria02;

// prueba para ver el funcionamiento de los hilos con respecto al orden de ejecucion
public class Ejercicio2 {
    static void main() {
        // Creamos una clase Hilo, que al ejecutarse (run()) imprimira por consola 5 mensajes
        Hilo hilo1 = new Hilo();
        // No ejecutamos el metodo run(), sino que iniciamos el hilo (posteriormente ejecutara run())
        hilo1.start();
        // Comprobamos como se ejecuta previamente esta linea, ya que run() se ejecutara despues
        System.out.println("El programa sigue su flujo");
    }
}
