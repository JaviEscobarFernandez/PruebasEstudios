package es.efjavi.practica.ejercicio8;

public class Producto {
    private final int id;
    private String nombre;
    private double precio;
    private int stock;
    private static int autoincrement;

    public Producto(String nombre, double precio, int stock) {
        this.id = ++autoincrement;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void vender(int cantidad) throws IllegalArgumentException {
        if (cantidad > stock)
            throw new IllegalArgumentException("Stock insuficiente para la venta.");
        stock -= cantidad;
        System.out.println("Se han vendido " + cantidad + " de " + nombre + " correctamente.");
    }

    public void reponer(int cantidad) throws IllegalArgumentException {
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad a reponer debe ser positiva.");
        stock += cantidad;
        System.out.println("Se han repuesto " + cantidad + " de " + nombre + " correctamente.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", Nombre: ")
                .append(nombre).append(", Precio: ").append(precio)
                .append("€, Stock: ").append(stock);
        return sb.toString();
    }
}
