package figuras;

public class Cuadrado extends FiguraGeometrica {
	private double lado;

	public Cuadrado(String color, double lado) {
		super(color);
		this.lado = lado;
	}

	public double getLado() { return this.lado; }

	@Override
	public double calcularArea(double lado) {
		this.setArea(lado * lado);
		return this.getArea();
	}
}
