package figuras;

public class Circulo extends FiguraGeometrica {
	private double radio;

	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}

	public double getRadio() { return this.radio; }

	@Override
	public double calcularArea(double radio) {
		this.setArea(Math.PI * Math.pow(radio, 2));
		return this.getArea();
	}
}
