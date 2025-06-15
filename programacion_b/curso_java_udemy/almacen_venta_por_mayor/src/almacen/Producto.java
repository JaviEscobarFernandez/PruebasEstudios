package almacen;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private static int autoincrement;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.idProducto = ++autoincrement;
    }

    public int getIdProducto() { return idProducto; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Precio: " + getPrecio() + "€" +
                ", Nombre: '" + getNombre() + '\'' +
                ", idProducto: " + getIdProducto();
    }
}
