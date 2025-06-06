package introduccion;

public class Booleanos {
    public static void main(String[] args) {
        boolean datoLogico = true;
        System.out.println("datoLogico = " + datoLogico);

        float f = 123.43f;
        double d = 98.23;
        datoLogico = f < d;
        System.out.println(f + " es menor que " + d + "? " + datoLogico);
        int a = 3;
        int b = 2;
        boolean esIgual = (a - b) == 1;
        System.out.println(a + " menos " + b + " es igual a 1? " + esIgual);
    }
}
