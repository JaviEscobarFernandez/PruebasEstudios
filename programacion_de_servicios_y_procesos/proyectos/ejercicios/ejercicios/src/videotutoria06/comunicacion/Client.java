package videotutoria06.comunicacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // Mismas variables que la clase servidor
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(String ip, int puerto) {
        try {
            // El cliente va directo al grano. Llama a la IP y al puerto.
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        // Abrimos las mismas tuberias que en el servidor
        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            salida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s) {
        try {
            salida.writeUTF(s);
            salida.flush();
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            entrada.close();
            salida.close();
            socket.close();
            mostrarTexto("ConexiÃ³n terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        }finally{
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        // Igual que el servidor. Hilo de fondo para escuchar lo que nos mandan
        // mientras nosotros seguimos escribiendo
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String texto = "";
        try {
            do {
                texto = entrada.readUTF();
                mostrarTexto("\n[Servidor] => " + texto);
                System.out.print("\n[Usted] => ");
            } while (!texto.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("[Usted] => ");
            entrada = teclado.nextLine();
            // Evitamos enviar mensajes vacios si le dan al intro sin querer
            if(!entrada.isEmpty())
                enviar(entrada);
        }
    }

    public static void main() {
        Client cliente = new Client();
        Scanner escaner = new Scanner(System.in);

        // AquÃ­ pedimos la IP. Como probamos en el mismo PC, serÃ¡ localhost.
        mostrarTexto("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.isEmpty())
            ip = "localhost";

        mostrarTexto("Puerto: [5050 por defecto] ");
        String puerto = escaner.nextLine();
        if (puerto.isEmpty())
            puerto = "5050";

        cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
        cliente.escribirDatos();
    }
}
