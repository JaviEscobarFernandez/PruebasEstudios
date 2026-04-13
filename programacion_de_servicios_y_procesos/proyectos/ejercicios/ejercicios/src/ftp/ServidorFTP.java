package ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ServidorFTP {
    public static void main(String[] args) {
        FtpServerFactory serverFactory = new FtpServerFactory();

        try {
            // Configurar el puerto para el servidor FTP
            ListenerFactory listenerFactory = new ListenerFactory();
            listenerFactory.setPort(2121);
            serverFactory.addListener("default", listenerFactory.createListener());

            // Configurar el usuario
            BaseUser user = new BaseUser();
            user.setName("testuser");
            user.setPassword("password");
            
            // Establecer el directorio home del usuario
            File homeDir = new File("ftp-home");
            if (!homeDir.exists()) {
                homeDir.mkdirs(); // Crea el directorio si no existe
            }
            user.setHomeDirectory(homeDir.getAbsolutePath());
            
            // Opcional: Dar permisos de escritura
            List<Authority> authorities = new ArrayList<>();
            authorities.add(new WritePermission());
            user.setAuthorities(authorities);

            // Añadir el usuario al gestor de usuarios
            serverFactory.getUserManager().save(user);

            // Iniciar el servidor
            FtpServer server = serverFactory.createServer();
            System.out.println("Servidor FTP iniciado en localhost, puerto 2121.");
            System.out.println("Usuario: testuser, Contraseña: password");
            System.out.println("Directorio raíz: " + homeDir.getAbsolutePath());
            System.out.println("Pulsa CTRL+C para detener el servidor.");
            server.start();

        } catch (FtpException e) {
            e.printStackTrace();
        }
    }
}