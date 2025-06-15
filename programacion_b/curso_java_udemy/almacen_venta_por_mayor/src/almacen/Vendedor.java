package almacen;

public class Vendedor extends Persona {
    private String nombreComercial;
    private int idVendedor;
    private static int autoincrement;
    private String localidad;
    private Producto[] productos;
    private int productoIncrement;

    final int MAX_PRODUCTO = 10;

    public Vendedor(String nombre, String apellidos, String DNI, String nombreComercial, String localidad) {
        super(nombre, apellidos, DNI);
        this.nombreComercial = nombreComercial;
        this.localidad = localidad;
        productos = new Producto[MAX_PRODUCTO];
        idVendedor = ++autoincrement;
    }

    public int getIdVendedor() { return idVendedor; }
    public String getNombreComercial() { return nombreComercial; }
    public String getLocalidad() { return localidad; }
    public Producto[] getProductos() { return productos; }

    public void addProducto(Producto producto) {
        if (productoIncrement >= MAX_PRODUCTO)
            return;
        this.productos[productoIncrement++] = producto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nNombre Comercial del vendedor: '" + getNombreComercial() + '\'');
        sb.append("\nIdentificador del vendedor: " + getIdVendedor());
        sb.append("\nLocalidad del vendedor: '" + getLocalidad() + '\'');
        sb.append("\nProductos:");
        for (Producto p : getProductos()) {
            if (p == null)
                break;
            sb.append("\n");
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }
}
