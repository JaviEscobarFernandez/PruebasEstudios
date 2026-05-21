package videotutoria09;

public class Principal {
    static void main() {
        // pruebaCesar();
        pruebaFuerzaBruta();
    }

    private static void pruebaCesar() {
        // probando cifrado cesar
        int numero = 4;
        String mensaje = "Microondas";
        System.out.println("Ejecutando cifrado Cesar:");
        System.out.println("El mensaje original es:" + mensaje);
        // codificar el mensaje desplazando 4 caracteres
        mensaje = CifradoCesar.codificarCesar(numero, mensaje);
        System.out.println("El mensaje codificado es: " + mensaje);
        // decodificar el mensaje desplazando 4 caracteres
        mensaje = CifradoCesar.decodificarCesar(numero, mensaje);
        System.out.println("El mensaje decodificado es: " + mensaje);
    }

    private static void pruebaFuerzaBruta() {
        // FuerzaBruta.reventarPass("javi");
        FuerzaBruta.reventarPassHard("javier");
    }
}
