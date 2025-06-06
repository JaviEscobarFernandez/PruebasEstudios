package introduccion;

public class Enteros {
    public static void main(String[] args) {
        // Enteros tipo byte
        byte numeroByte = 127;
        System.out.println("Número entero tipo byte: " + numeroByte);
        System.out.println("tipo byte en bytes: " + Byte.BYTES);
        System.out.println("tipo byte en bits: " + Byte.SIZE);
        System.out.println("máximo valor typo bytes: " + Byte.MAX_VALUE);
        System.out.println("mínimo valor typo bytes: " + Byte.MIN_VALUE);
        // Enteros tipo short
        short numeroShort = 32767;
        System.out.println("Número entero tipo short: " + numeroShort);
        System.out.println("tipo short en bytes: " + Short.BYTES);
        System.out.println("tipo short en bits: " + Short.SIZE);
        System.out.println("máximo valor typo short: " + Short.MAX_VALUE);
        System.out.println("mínimo valor typo short: " + Short.MIN_VALUE);
        // Enteros tipo integer
        int numeroInteger = 2147483647;
        System.out.println("Número entero tipo integer: " + numeroInteger);
        System.out.println("tipo integer en bytes: " + Integer.BYTES);
        System.out.println("tipo integer en bits: " + Integer.SIZE);
        System.out.println("máximo valor typo integer: " + Integer.MAX_VALUE);
        System.out.println("mínimo valor typo integer: " + Integer.MIN_VALUE);
        // Enteros tipo long
        long numeroLong = 9223372036854775807L;
        System.out.println("Número entero tipo long: " + numeroLong);
        System.out.println("tipo long en bytes: " + Long.BYTES);
        System.out.println("tipo long en bits: " + Long.SIZE);
        System.out.println("máximo valor typo long: " + Long.MAX_VALUE);
        System.out.println("mínimo valor typo long: " + Long.MIN_VALUE);
        // variable dinamica
        var numeroDinamico = 2147483647;
        System.out.println(numeroDinamico);
    }
}
