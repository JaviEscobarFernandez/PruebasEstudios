package videotutoria07;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Principal {

    public static void pruebaTelnet() throws IOException {
        Telnet telnet = new Telnet();
        telnet.conectar("igormud.org", 1701, "Ilerna", "Ilerna");
    }

    public static void pruebaJSON() throws MalformedURLException, IOException {
        ClienteJSON json = new ClienteJSON();
        URL url = new URL("https://api.el-tiempo.net/json/v3/provincias");
        // Mostramos las provincias de la API de elTiempo.net
		/*String provincias = json.respuestaJSON(url);
		System.out.println("Listado de Provincias de elTiempo.net - Formato JSON leído sin librería");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(provincias);*/

        JSONObject obJson = json.respuestaJSONLibrería(url);
        System.out.println("\n\nListado de Provincias de elTiempo.net - Formato JSON leído con librería");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(obJson.toString());
        System.out.println("\n\nAccedemos a la propiedad 'provincias' del objeto JSON");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(obJson.get("provincias"));

        System.out.println("\n\nAccedemos a la propiedad 'provincias' del objeto JSON como un Array");
        System.out.println("----------------------------------------------------------------------------");
        JSONArray arrayJson = obJson.getJSONArray("provincias");
        for(int i=0; i<arrayJson.length(); i++) {
            System.out.println(arrayJson.get(i));
        }

    }

    public static void main(String[] args) {
        try {

            // pruebaTelnet();
            pruebaJSON();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}