package videotutoria06.comunicacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    // declaramos las variables para la comunicacion
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream entrada; // tuberia de entrada de datos
    private DataOutputStream salida; // tuberia de salida de datos

    Scanner scanner = new Scanner(System.in); // encargado de la lectura y escritura en los flujos de entrada y salida

    final String COMANDO_TERMINACION = "salir()"; // palabra magica para finalizar comunicacion

    public void iniciarConexion(int puerto) {
        try {
            mostrarTexto("esperando conexion entrante en el puerto: " + String.valueOf(puerto));
            // dejamos al servidor a la espera de peticion del cliente
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().toString() + "\n\n\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void iniciarFlujos() {
        try {
            // establecemos la conexion de los flujos a traves de las tuberias hacia el cliente que se conecta
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            // usamos flush para forzar en caso de que hubiese algo atascado (realmente es necesario?)
            salida.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void recibirDatos() {
        String texto = "";
        // lo dejamos en bucle con la conexion hasta que introduzca el comando de salida
        try {
            do {
                texto = entrada.readUTF();
                mostrarTexto("\n[Cliente] => " + texto);
                mostrarTexto("\n[Self] => ");
            } while (!texto.equals(COMANDO_TERMINACION));
        } catch (Exception e) {
            cerrarConexion();
        }
    }

    public void enviarDatos(String texto) {
        try {
            // escribimos el mensaje y limpiamos la tuberia para forzar el envio inmediato al cliente
            salida.writeUTF(texto);
            salida.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void escribirDatos() {
        // creamos un bucle infinito para poder escribir y enviar informacion constantemente
        while (true) {
            System.out.println("[Self] => ");
            enviarDatos(scanner.nextLine());
        }
    }

    public void ejecutarConexion(int puerto) {

        // Punto clave: establecemos la escucha en un hilo paralelo para no bloquear el principal
        // para poder recibir mensajes mientras nosotros enviamos tambien mensajes
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // establecemos el socketservidor cuando ejecutamos la conexion por primera vez para no duplicar
                    serverSocket = new ServerSocket(puerto);

                    while (true) {
                        try {
                            iniciarConexion(puerto);
                            iniciarFlujos();
                            recibirDatos();
                        } finally {
                            cerrarConexion();
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        // ejecutamos el hilo en paralelo con start(), luego internamente ya ejecuta run()
        hilo.start();
    }
    private void cerrarConexion() {
        try {
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            mostrarTexto("Comunicación finalizada");
            System.exit(0);
        }
    }

    private static void mostrarTexto(String texto) {
        System.out.println(texto);
    }

    static void main() {
        // creamos el servidor y un escaner para el texto a recoger
        Server servidor = new Server();
        Scanner sc = new Scanner(System.in);

        // solicitamos que introduzca el puerto
        mostrarTexto("Introduce el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();

        if (puerto.length() <= 0)
            puerto = "5050";

        // establecemos la conexion
        servidor.ejecutarConexion(Integer.parseInt(puerto));
        servidor.escribirDatos();
    }
}
