package almacen;

public class NoPerecedero extends Producto {
    private String color;

    public NoPerecedero(String nombre, double precio, String color) {
        super(nombre, precio);
        this.color = color;
    }

    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Producto Tipo: NoPerecedero\n" +
                super.toString() + "\nColor: " + getColor();
    }
}
