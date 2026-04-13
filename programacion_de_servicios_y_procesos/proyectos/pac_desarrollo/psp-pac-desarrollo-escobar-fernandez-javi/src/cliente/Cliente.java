package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    // metodo para iniciar la funcionalidad del cliente
    // se conecta al servidor e interactua
    public void start() {
        try (Socket socket = new Socket("localhost", 4321)) {
            // abrir flujo para leer y escribir al cliente y teclado
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            // leer del servidor preguntar nombre
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor bienvenida
            System.out.println(bf.readLine());

            // leer del servidor descripcion
            System.out.println(bf.readLine());

            // leer del servidor preguntar mayusculas
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor preguntar minusculas
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor preguntar digitos
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor preguntar caracteres especiales
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor la longitud de la pass
            System.out.println(bf.readLine());

            // leer del servidor generar pass?
            System.out.println(bf.readLine());
            pw.println(teclado.readLine());

            // leer del servidor pass o despedida
            System.out.println(bf.readLine());

            // no necesitamos cerrar socket en este tipo de try
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
