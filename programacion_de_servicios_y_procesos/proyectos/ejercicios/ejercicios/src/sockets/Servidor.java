package sockets;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            // El servidor escucha en el puerto 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado. Esperando clientes...");

            // Aceptar la conexión del cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

            // Leer datos del cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String mensajeRecibido = in.readLine();
            System.out.println("Mensaje del cliente: " + mensajeRecibido);

            // Enviar respuesta al cliente
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hola, cliente. Mensaje recibido con éxito.");

            // Cerrar conexiones
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}