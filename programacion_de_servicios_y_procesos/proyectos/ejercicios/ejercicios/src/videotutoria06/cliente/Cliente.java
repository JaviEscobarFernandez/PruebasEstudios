package videotutoria06.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    private final String HOST = "localhost";
    private final int PORT = 4321;
    private Socket socket;

    public Cliente() throws IOException {
        socket = new Socket(HOST, PORT); // al crear un cliente establecemos el socket del cliente para que conecte al servidor
    }

    public void iniciarCliente() throws IOException {
        // iniciamos el flujo de entrada de datos
        DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());

        // mostramos el mensaje recibido por pantalla
        System.out.println(entradaServidor.readUTF());

        // iniciamos el flujo de salida de datos hacia el servidor
        DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());

        // enviamos 3 mensajes al servidor
        for (int i = 1; i < 4; i++)
            salidaServidor.writeUTF("Enviando mensaje número: " + i);

        // cerramos flujos y socket al finalizar
        salidaServidor.close();
        entradaServidor.close();
        socket.close();
    }
}
