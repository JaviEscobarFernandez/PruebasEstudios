package videotutoria02;

// Prueba para comprobar el funcionamiento de un proceso con respecto a su estado bloqueado
public class Ejercicio1 {
    static void main() {
        // Creamos un constructor de procesos para ejecutar el bloc de notas
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        System.out.println("Ejecutar bloc de notas");
        try {
            System.out.println("Iniciando proceso");
            // Creamos un proceso especifico
            Process process1 = pb.start();
            // Bloqueamos el proceso dejandolo a la espera de la interaccion del usuario con el bloc de notas
            process1.waitFor();
            // Hasta que no interactua el usuario con el bloc de notas para cerrarlo, el fluho no pasa a esta ultima linea
            System.out.println("El proceso ha finalizado su ejecución");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
