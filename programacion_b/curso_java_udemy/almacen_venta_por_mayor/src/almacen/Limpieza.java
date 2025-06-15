package almacen;

public class Limpieza extends Producto {
    private String tipo;

    public Limpieza(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Producto Tipo: Limpieza\n" +
                super.toString() + "\nTipo: " + getTipo();
    }
}
