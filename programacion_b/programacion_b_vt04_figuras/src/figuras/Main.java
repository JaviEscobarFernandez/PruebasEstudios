package figuras;

/*
 * Ejercicio videotutoria 04 en vivo:
 * Crea un proyecto Java que contenga las Clases FiguraGeometrica, Cuadrado, Circulo y Triangolo
 * La clase FiguraGeometrica con atributos color (String) y area (double). Tendra un constructor,
 * getters y setters, y un método sobrecargado calcularArea tanto con un parametro double como con
 * dos parametros que devuelven en ambos casos un valor 0.
 * Las clases Triangulo, Cuadrado y Circulo hereden de la clase FiguraGeometrica y tienen distintos
 * atributos double. Triangulo 2 atributos, base y altura. Cuadrado 1 atributo, lado. Circulo 1 atributo radio.
 * Sobrescribe en las clases detivadas el metodo calcularArea de acuerdo a su correpsondiente formula.
 * En el metodo main, instancia al menos un objeto de cada clase derivada y calcula el area de cada uno de ellos.
 */
public class Main {

	public static void main(String[] args) {
		// Instanciamos el triangulo y calculamos su area
		Triangulo triangulo = new Triangulo("Amarillo", 4, 10);
		double areaTriangulo = triangulo.calcularArea(triangulo.getBase(), triangulo.getAltura());
		System.out.println("El área del triangulo de color: " + triangulo.getColor() + " con Base: " + triangulo.getBase() +
				" y Altura: " + triangulo.getAltura() + " es de: " + areaTriangulo);

		// Instanciamos el circulo y calculamos su area
		Circulo circulo = new Circulo("Rojo", 5);
		double areaCirculo = circulo.calcularArea(circulo.getRadio());
		System.out.println("El área del circulo de color: " + circulo.getColor() + " con Radio: " + circulo.getRadio() +
				" es de: " + areaCirculo);

		// Instanciamos el cuadrado y calculamos su area
		Cuadrado cuadrado = new Cuadrado("Azul", 9);
		double areaCuadrado = cuadrado.calcularArea(cuadrado.getLado());
		System.out.println("El área del cuadrado de color: " + cuadrado.getColor() + " con Lado: " + cuadrado.getLado() +
				" es de: " + areaCuadrado);
	}

}
