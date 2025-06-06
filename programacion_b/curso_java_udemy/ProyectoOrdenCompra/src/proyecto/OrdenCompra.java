package proyecto;

import java.util.Date;

public class OrdenCompra {
    private int identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private int contadorProducto;

    private static int autoincrementId;

    OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        productos = new Producto[4];
        identificador = ++autoincrementId;
    }

    public int getIdentificador() { return identificador; }
    public Producto[] getProductos() { return productos; }
    public Cliente getCliente() { return cliente; }
    public Date getFecha() { return fecha; }
    public String getDescripcion() { return descripcion; }

    public void setCliente(Cliente c) { cliente = c; }
    public void setFecha(Date d) { fecha = d; }

    public void addProducto(Producto producto) {
        if (contadorProducto >= getProductos().length) {
            System.err.println("ERROR: se ha llegado al limite de productos, no puedes añadir más.");
            return;
        }
        productos[contadorProducto++] = producto;
    }

    public int obtenerPrecioTotal() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public String imprimirOrden() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden ID: " + getIdentificador());
        if (getCliente() != null)
            sb.append("\nCliente: " + getCliente().getNombre() + " " + getCliente().getApellido());
        if (getFecha() != null)
            sb.append("\nFecha: " + getFecha());
        sb.append("\nDescripción: " + getDescripcion());
        for (Producto p : productos) {
            sb.append("\nProducto - Fabricante: " + p.getFabricante() + " - Nombre: " + p.getNombre() + " - Precio: " + p.getPrecio() + "€");
        }
        sb.append("\nPrecio total: " + obtenerPrecioTotal() + "€");
        return sb.toString();
    }
}
