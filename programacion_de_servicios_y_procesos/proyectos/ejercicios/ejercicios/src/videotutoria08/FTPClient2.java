package videotutoria08;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.Scanner;

public class FTPClient2 {
    private String server = "127.0.0.1";
    private int port = 21;
    private String user = "prueba";
    private String password = "prueba";
    private FTPClient ftp;

    // constructor

    void open() throws IOException {
        Scanner teclado = new Scanner(System.in);
        ftp = new FTPClient();

        System.out.println("Iniciando conexión al servidor " + server);
        //Establecemos la conexión con el socket para comunicarse
        ftp.connect(server,port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }


        System.out.println("Servidor En línea");
        System.out.println("Iniciando sesión en el servidor.");

        //Establecemos modo de conexión PASIVO:
        //El servidor está a la espera de que un cliente se conecte
        ftp.enterLocalPassiveMode();
        ftp.login(user, password);
        ftp.setControlEncoding("UTF-8");

        //Indica en qué directorio nos encontramos
        System.out.println("DIRECTORIO ACTUAL: " + ftp.printWorkingDirectory());


        //Mostrar todos los subdirectorios que se encuentran en esta ubicación
        //Generamos la lista de directorios
        FTPFile[] directorios = ftp.listDirectories();

        //Los convertimos para que podemos entenderlos
        for (FTPFile directorio1 : directorios) {
            System.out.println("\t\t" + directorio1.getName());
        }


        //MOVERNOS A OTRO DIRECTORIO
        System.out.println("¿A qué directorio quieres moverte?");
        String directorio2 = teclado.next();
        System.out.println("Cambiando directorio . . .");
        ftp.changeWorkingDirectory(directorio2);
        System.out.println("DIRECTORIO ACTUAL: " + ftp.printWorkingDirectory());


        //Mostrar todos los ficheros que se encuentran en este directorio
        FTPFile[] archivos;
        boolean existe=false;
        String name="";

        System.out.println("Listado de ficheros en: " + ftp.printWorkingDirectory());
        archivos = ftp.listFiles();
        //En cada iteración crea un archivo y extrae el nombre para mostrarlo
        for (FTPFile archivo : archivos) {
            System.out.println("\t\t" + archivo.getName());
        }

        //DESCARGAR UN FICHERO
        //Preguntamos qué fichero quieres descargar
        do{
            System.out.println("¿Qué fichero quieres descargar?: ");

            name = teclado.next();
            if (!(existe=(existe(archivos, name)))) {
                System.out.println("El archivo especificado no existe");
            }
        }while (!existe);


        //Creamos un flujo entre el cliente y el servidor
        File downloadFile = new File("./ficheros/ftp/" + name); //Ruta de mi proyecto
        System.out.println("Descargando fichero...");

        //Abrimos el flujo de escritura
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));

        //Leemos el fichero que vamos a descargar
        InputStream inputStream = ftp.retrieveFileStream(name); //Buscar este método en la documentación commons apache

        //Transformamos los bytes del fichero para copiarlos
        byte[] bytesArray = new byte[4096]; //Damos un tamaño muy grande para asegurarnos de que cabe
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead); //leemos del inputstream hasta llegar al final del fichero
            //Lo que queremos leer, el offset, la longitud
        }

        //Verificamos si se ha completado el último comando sobre FTP
        boolean success = ftp.completePendingCommand();
        if (success) {
            System.out.println("Fichero descargado correctamente.");
        }

        //cerramos la conexión para que guarde el contenido del buffer en el fichero
        outputStream.close();
        inputStream.close();
        ftp.logout();
    }

    void close() throws IOException {
        ftp.disconnect();
    }

    private boolean existe(FTPFile[] archivos, String file) {
        for (FTPFile archivo : archivos) {
            if (archivo.getName().equals(file))
                return true;
        }
        return false;

    }
}

