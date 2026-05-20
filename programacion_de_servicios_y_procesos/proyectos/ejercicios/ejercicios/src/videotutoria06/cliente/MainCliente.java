package videotutoria06.cliente;

import java.io.IOException;

public class MainCliente {
    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        System.out.println("Iniciando cliente...");

        // Iniciamos la conexion
        cliente.iniciarCliente();
    }
}
