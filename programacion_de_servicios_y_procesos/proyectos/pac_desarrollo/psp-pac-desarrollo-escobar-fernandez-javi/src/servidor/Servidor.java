package servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    // metodo para iniciar la funcionalidad del servidor
    // se queda a la escucha y cuando un cliente se conecta interactua
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(4321)) {
            while (true) {
                // abrimos socket para estar a la escucha hasta que conecte un cliente
                Socket socket = serverSocket.accept();

                // abrir flujo para leer y escribir al cliente
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                String line = "";

                // preguntar nombre al cliente
                pw.println("Hola, introduce tu nombre por favor:");
                line = bf.readLine();
                String nombre = line;

                // dar la bienvenida al cliente
                pw.println("Bienvenido al club: " + nombre);

                // enviar descripcion al cliente
                pw.println("######## Servicio para generar contraseñas aleatorias ########");

                // preguntar mayusculas al cliente
                pw.println("Introduce un numero entero para las mayúsculas:");
                line = bf.readLine();
                int numMayus = validarNumero(line);

                // preguntar minusculas al cliente
                pw.println("Introduce un numero entero para las minúsculas:");
                line = bf.readLine();
                int numMinus = validarNumero(line);

                // preguntar digitos al cliente
                pw.println("Introduce un numero entero para los dígitos:");
                line = bf.readLine();
                int numDigits = validarNumero(line);

                // preguntar caracteres especiales al cliente
                pw.println("Introduce un numero entero para los caracteres especiales:");
                line = bf.readLine();
                int numEspeciales = validarNumero(line);

                // crear el objeto de requisitos
                RequisitosPass req = new RequisitosPass();
                req.setNumCaractEspeciales(numEspeciales);
                req.setNumMinusculas(numMinus);
                req.setNumMayusculas(numMayus);
                req.setNumDigitos(numDigits);

                // enviar la longitud de la contraseña al cliente
                pw.println("La contraseña tendrá una longitud de " + ServicioPass.getPassLength(req) + " caracteres");

                // preguntar si quiere generar pass al cliente
                pw.println("¿Quieres generar una contraseña? s/n");
                line = bf.readLine();
                if (line.equalsIgnoreCase("s") || line.equalsIgnoreCase("si") || line.equalsIgnoreCase("sí")) {
                    pw.println("La contraseña es: " + ServicioPass.generateRandomPass(req));
                }
                else {
                    pw.println("Adios!");
                }

                // cerramos el socket de comunicacion con el cliente
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para validar el numero en base al string obtenido
    // si no es valido, lo dejamos por defecto en 1, asi evitamos crash
    private int validarNumero(String numero) {
        int num;
        try {
            num = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            num = 1;
        }
        return num;
    }
}
