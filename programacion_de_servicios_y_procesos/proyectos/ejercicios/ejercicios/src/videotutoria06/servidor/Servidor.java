package videotutoria06.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int PORT = 4321;
    private ServerSocket serverSocket;
    private Socket socket;

    public Servidor() throws IOException {
        // al crear el servidor establecemos el serversocket y socket para aceptar conexion y el intercambio de informacion
        // serverSocket acepta las peticiones, socket realiza la comunicacion (envio y recepcion de mensajes)
        serverSocket = new ServerSocket(PORT);
        socket = new Socket(); // no necesita un puerto concreto
    }

    public void iniciarServer() throws IOException {
        // bucle para aceptar peticiones
        while (true) {
            System.out.println("Esperando peticion del cliente");
            // dejamos a la espera de que llegue una peticion
            socket = serverSocket.accept(); // cuando acepta una peticion establecemos el socket para la comunicacion

            // iniciamos el flujo de salida de datos hacia el cliente
            DataOutputStream mensajeCliente = new DataOutputStream(socket.getOutputStream());
            // enviamos un mensaje al cliente
            mensajeCliente.writeUTF("Petición recibida");

            // iniciamos el flujo de entrada de datos
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            // validamos el mensaje recibido y lo imprimimos
            String mensajeDelCliente;
            try {
                while (!(mensajeDelCliente = entrada.readUTF()).isEmpty())
                    System.out.println(mensajeDelCliente);
            } catch (IOException e) {
                System.err.println(e);
            }

            // cerramos flujos y socket al finalizar
            mensajeCliente.close();
            entrada.close();
            socket.close();
        }
    }

    public void finalizarServer() throws IOException {
        serverSocket.close();
    }
}
