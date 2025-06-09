package es.efjave.poosobrecarga;

public class Calculadora {

    private Calculadora() { }

    public static int sumar(int a, int b) { return a + b; }
    public static float sumar(float a, int b) { return a + b; }
    public static float sumar(float a, float b) { return a + b; }
    public static float sumar(int a, float b) { return a + b; }
    public static double sumar(double a, double b) { return a + b; }
    public static int sumar(String a, String b) {
        int result = 0;
        try {
            result = Integer.parseInt(a) + Integer.parseInt(b);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    public static int sumar(int a, int b, int c) { return a + b + c; }

    public static int sumar(int... argumentos) {
        int total = 0;
        for (int i : argumentos) {
            total += i;
        }
        return total;
    }

    public static float sumar(float... argumentos) {
        float total = 0;
        for (float f : argumentos) {
            total += f;
        }
        return total;
    }

    public static double sumar(double... varargs) {
        double total = 0;
        for (double d : varargs) {
            total += d;
        }
        return total;
    }
}
