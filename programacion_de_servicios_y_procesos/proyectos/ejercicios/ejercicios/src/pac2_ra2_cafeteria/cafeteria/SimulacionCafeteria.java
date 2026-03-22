package pac2_ra2_cafeteria.cafeteria;

public class SimulacionCafeteria {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("La cafetería abre.");

        // Creamos un barista
        Barista barista = new Barista();
        Thread hiloBarista = new Thread(barista, "HiloBarista");

        // Iniciamos los hilos
        hiloBarista.start(); // El barista empieza a trabajar

        // Creamos 3 clientes que será atendido por Pedro
        for (int i = 1; i < 4; i++) {
            Cliente cliente = new Cliente(i, hiloBarista);
            Thread hiloCliente = new Thread(cliente);
            hiloCliente.start();
            // hiloCliente.join();// El cliente llega y pide
        }

        System.out.println("Barista prepara sus pedidos.");
        // El hilo main podría terminar aquí, pero los hilos de barista y cliente seguirán ejecutándose.
    }
}
