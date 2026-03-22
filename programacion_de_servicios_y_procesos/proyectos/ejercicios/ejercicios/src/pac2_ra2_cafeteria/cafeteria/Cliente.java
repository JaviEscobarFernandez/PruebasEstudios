package pac2_ra2_cafeteria.cafeteria;

class Cliente implements Runnable {
    private int numCliente;
    private Thread hiloDelBaristaAsignado;

    public Cliente(int numCliente, Thread hiloBarista) {
        this.numCliente = numCliente;
        this.hiloDelBaristaAsignado = hiloBarista;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + numCliente + " ha realizado un pedido y espera.");
        try {
            // El cliente espera a que el barista termine de preparar su café
            if (hiloDelBaristaAsignado != null) {
                hiloDelBaristaAsignado.join(); // Espera a que el hilo del barista termine
                System.out.println("Cliente " + numCliente + " ha recibido su café.");
            }
        } catch (InterruptedException e) {
            System.out.println("Cliente " + numCliente + " fue interrumpido mientras esperaba su café.");
            Thread.currentThread().interrupt();
        }
    }
}
