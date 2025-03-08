package figuras;

public class FiguraGeometrica {
	private String color;
	private double area;

	public FiguraGeometrica(String color) {
		this.color = color;
	}

	public String getColor() { return this.color; }
	public double getArea() { return this.area; }

	public void setColor(String color) { this.color = color; }
	public void setArea(double area) { this.area = area; }

	public double calcularArea(double param1) { return 0; }
	public double calcularArea(double param1, double param2) { return 0; }
}
