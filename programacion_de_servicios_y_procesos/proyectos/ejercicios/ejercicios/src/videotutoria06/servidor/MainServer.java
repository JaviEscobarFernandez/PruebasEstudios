package videotutoria06.servidor;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor();
        System.out.println("Iniciando servidor . . .");

        // Iniciamos el servidor
        server.iniciarServer();

        // finalizamos el servidor
        server.finalizarServer();
    }
}
