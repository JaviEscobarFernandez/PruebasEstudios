package almacen;

public class Fruta extends Producto {
    private double peso;
    private String color;

    public Fruta(String nombre, double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() { return peso; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        System.out.println("Producto de tipo: Fruta");
        return super.toString() + "\nDetalles:\nPeso: " + getPeso() + ", Color: " + getColor();
    }
}
