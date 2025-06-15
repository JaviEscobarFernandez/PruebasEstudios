package almacen;

public class Lacteo extends Producto {
    private int cantidad;
    private int proteinas;

    public Lacteo(String nombre, double precio, int cantidad, int proteinas) {
        super(nombre, precio);
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public int getCantidad() { return cantidad; }
    public int getProteinas() { return proteinas; }

    @Override
    public String toString() {
        System.out.println("Producto de tipo: Lacteo");
        return super.toString() + "\nDetalles:\nCantidad: " + getCantidad() + ", Proteinas: " + getProteinas();
    }
}
