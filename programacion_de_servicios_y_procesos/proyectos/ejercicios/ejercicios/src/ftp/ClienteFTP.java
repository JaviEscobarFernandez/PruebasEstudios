package ftp;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP {
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String servidor = "localhost";
        int puerto = 2121;
        

        try {
            // 1. Conectar al servidor FTP
            System.out.println("Conectando al servidor: " + servidor);
            ftpClient.connect(servidor, puerto);
            
            // 2. Iniciar sesión con credenciales de usuario (anónimo)
            boolean loginExitoso = ftpClient.login("testuser", "password");
            if (loginExitoso) {
                System.out.println("Login exitoso.");

                // 3. Listar archivos del directorio actual
                System.out.println("Listando archivos del directorio raíz...");
                FTPFile[] archivos = ftpClient.listFiles();

                if (archivos != null && archivos.length > 0) {
                    for (FTPFile archivo : archivos) {
                        if (archivo.isFile()) {
                            System.out.println("  - Archivo: " + archivo.getName());
                        } else if (archivo.isDirectory()) {
                            System.out.println("  - Directorio: " + archivo.getName());
                        }
                    }
                } else {
                    System.out.println("  El directorio está vacío.");
                }
            } else {
                System.out.println("Login fallido. Verifica el usuario y la contraseña.");
            }
        } catch (IOException e) {
            System.err.println("Error de conexión FTP: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 4. Desconectar del servidor
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    System.out.println("Desconectado del servidor FTP.");
                }
            } catch (IOException e) {
                System.err.println("Error al desconectar: " + e.getMessage());
            }
        }
    }
}
