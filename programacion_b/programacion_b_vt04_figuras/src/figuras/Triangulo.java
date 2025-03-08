package figuras;

public class Triangulo extends FiguraGeometrica {
	private double base;
	private double altura;

	public Triangulo(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}

	public double getBase() { return this.base; }
	public double getAltura() { return this.altura; }

	@Override
	public double calcularArea(double base, double altura) {
		this.setArea(0.5 * base * altura);
		return this.getArea();
	}
}
