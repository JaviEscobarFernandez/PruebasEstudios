package es.efjave.appfacturas.modelo;

public class ItemFactura {
    private int cantidad;
    private Producto producto;

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto p) { producto = p; }

    public double calcularImporte() {
        return getCantidad() * getProducto().getPrecio();
    }

    @Override
    public String toString() {
        return producto.toString() +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}
