package videotutoria07;


import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;

public class Telnet {


    private InputStream in;
    private PrintStream out;
    private BufferedReader reader;
    private String prompt=">";

    /**
     * Método donde hacermos la prueba de conexión al servidor Telnet
     * @param servidor url del servidor al que nos vamos a conectar
     * @param puerto número de puerto para conectarnos
     * @param usuario nombre de usuario
     * @param password contraseña del usuario
     * @throws IOException
     */
    public void conectar(String servidor, int puerto, String usuario, String password) throws IOException {
        TelnetClient telnet = new TelnetClient();
        telnet.connect(servidor, puerto);

        // Para leer la información del servidor Telnet
        this.in = telnet.getInputStream();

        // Para poder mandar la información al servidor Telnet
        this.out = new PrintStream(telnet.getOutputStream());

        // Ahora envuelvo el InputStream dentro de un BufferedReader
        // Lectura de las respuestas del telnet sean mucho más sencillas y mejor gestionadas
        reader = new BufferedReader(new InputStreamReader(in));

        // Introducimos usuario y contraseña para el servidor
        leerHasta("What is your name:");
        escribeAlServidor(usuario);
        leerHasta("Password:");
        escribeAlServidor(password);

        // Probamos un par de comandos
        leerHasta(prompt);
        escribeAlServidor("users"); // Lista los usuarios del juego
        leerHasta(prompt);
        escribeAlServidor("quit");
        leerHasta(usuario);

        //Cerramos conexión y liberamos recursos
        out.close();
        reader.close();
        in.close();
        telnet.disconnect();
    }

    /**
     * Método para leer hasta que aparezca un patrón
     * @param pattern patrón a revisar
     * @return lo leído del servidor Telnet
     * @throws IOException
     */
    public String leerHasta(String pattern) throws IOException {
        StringBuffer sb = new StringBuffer();
        char lastChar = pattern.charAt(pattern.length() - 1);

        int check = in.read();
        char ch = (char) check;
        while (check != -1) {
            System.out.print(ch);
            sb.append(ch);
            if (ch == lastChar) {
                if (sb.toString().endsWith(pattern)) {

                    return sb.toString();
                }
            }
            check = in.read();
            ch = (char) check;
        }

        return sb.toString();
    }

    /**
     * Método para escribir al servidor Telnet
     * @param value cadena que mandamos al servidor Telnet
     */
    public void escribeAlServidor(String value) {
        out.println(value);
        out.flush();
        System.out.println(value);
    }
}

