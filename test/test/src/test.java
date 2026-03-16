import java.net.URL;
import java.net.URLConnection;

URL miUrl = new URL("..."); // 1. Creas la URL:
URLConnection conexion = miUrl.openConnection(); // 2. Abres el túnel:
conexion.connect(); // 3. Te conectas y trabajas:
