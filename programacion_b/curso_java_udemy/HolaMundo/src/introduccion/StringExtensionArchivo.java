package introduccion;

public class StringExtensionArchivo {
    public static void main(String[] args) {
        String archivo = "imagen.png";
        int i = archivo.lastIndexOf(".");
        System.out.println("archivo.lenght() = " + archivo.length());
        System.out.println("archivo.substring(archivo.length()-3) = " + archivo.substring(archivo.length()-3));
        System.out.println("archivo.substring(i + 1) = " + archivo.substring(i + 1));
    }
}
