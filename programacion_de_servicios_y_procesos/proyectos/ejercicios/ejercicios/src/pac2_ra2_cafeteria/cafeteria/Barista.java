package pac2_ra2_cafeteria.cafeteria;

class Barista implements Runnable {

    @Override
    public void run() {
        System.out.println("Barista empieza a trabajar.");
        try {
            for (int i = 1; i < 4; i++) {
                // Simula el tiempo que tarda en preparar el café
                Thread.sleep(2000); // Prepara café durante 2 segundos
                System.out.println("Barista ha terminado el café del cliente "+ i + ".");
            }
            System.out.println("Barista ha terminado los pedidos.");
        } catch (InterruptedException e) {
            System.out.println("Barista fue interrumpido mientras preparaba el café.");
            Thread.currentThread().interrupt(); // Buena práctica restaurar el estado de interrupción
        }
    }
}
