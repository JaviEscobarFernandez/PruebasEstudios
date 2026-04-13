package sockets;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // El cliente se conecta al servidor en localhost en el puerto 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor.");

            // Enviar mensaje al servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hola, servidor.");

            // Leer la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuestaServidor = in.readLine();
            System.out.println("Respuesta del servidor: " + respuestaServidor);

            // Cerrar conexión
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}