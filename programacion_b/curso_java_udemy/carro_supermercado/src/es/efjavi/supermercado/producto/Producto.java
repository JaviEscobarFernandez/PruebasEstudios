package es.efjavi.supermercado.producto;

import java.util.List;

public abstract class Producto {
    protected String nombre;
    protected Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
}
