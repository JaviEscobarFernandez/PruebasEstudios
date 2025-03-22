package ejercicio_9;

public class Geometria {

    // Realizo los metodos estaticos, asi no es necesario instanciar la clase.
    public static double areaCuadrado(int lado) {
        return lado * lado;
    }

    public static double areaCirculo(int radio) {
        return 2 * Math.PI * radio;
    }

    public static double areaTriangulo(int base, int altura) {
        return base * altura;
    }
}
