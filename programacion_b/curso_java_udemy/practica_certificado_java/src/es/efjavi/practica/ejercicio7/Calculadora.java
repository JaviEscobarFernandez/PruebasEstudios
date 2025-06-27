package es.efjavi.practica.ejercicio7;

public class Calculadora {
    public static<T extends Number> double sumar(T a, T b) { return a.doubleValue() + b.doubleValue(); }
    public static<T extends Number> double restar(T a, T b) { return a.doubleValue() - b.doubleValue(); }
    public static<T extends Number> double multiplicar(T a, T b) { return a.doubleValue() * b.doubleValue(); }
    public static<T extends Number> double dividir(T a, T b) {
        if (b.equals(0))
            throw new DivisionPorCeroException("ERROR: no es posible dividir entre 0");
        return a.doubleValue() / b.doubleValue();
    }
}
