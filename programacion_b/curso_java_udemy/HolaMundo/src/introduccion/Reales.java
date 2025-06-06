package introduccion;

public class Reales {
    static float variableDinamica = 3.1416f;
    public static void main(String[] args) {
        // Reales tipo float
        float numeroFloat = 10.2f;
        System.out.println("Número real tipo float: " + numeroFloat);
        System.out.println("tipo float en bytes: " + Float.BYTES);
        System.out.println("tipo float en bits: " + Float.SIZE);
        System.out.println("máximo valor typo float: " + Float.MAX_VALUE);
        System.out.println("mínimo valor typo float: " + Float.MIN_VALUE);
        // Reales tipo double
        double numeroDouble = 3.4028235E38;
        System.out.println("Número real tipo double: " + numeroDouble);
        System.out.println("tipo double en bytes: " + Double.BYTES);
        System.out.println("tipo double en bits: " + Double.SIZE);
        System.out.println("máximo valor typo double: " + Double.MAX_VALUE);
        System.out.println("mínimo valor typo double: " + Double.MIN_VALUE);

        System.out.println("Probando variable dinamica: " + variableDinamica);
    }
}
