package videotutoria09;

public class CifradoCesar {
    public static String codificarCesar(int numero, String cadena) {
        // almacenamos en un StringBuilder la cadena recibida, caracter a caracter y le sumamos el numero para desplazar el caracter
        StringBuilder cadenaCodificada = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++)
            cadenaCodificada.append(Character.toString(cadena.charAt(i) + numero));

        return cadenaCodificada.toString();
    }

    public static String decodificarCesar(int numero, String cadena) {
        // almacenamos en un StringBuilder la cadena recibida, caracter a caracter y le restamos el numero para desplazar el caracter
        StringBuilder cadenaDecodificada = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++)
            cadenaDecodificada.append(Character.toString(cadena.charAt(i) - numero));

        return cadenaDecodificada.toString();
    }
}
