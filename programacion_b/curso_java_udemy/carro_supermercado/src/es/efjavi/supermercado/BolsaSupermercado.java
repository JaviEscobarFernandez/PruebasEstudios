package es.efjavi.supermercado;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T> {
    private List<T> productos;
    private int id;
    private static int autoincrement;
    static final int MAX_PRODUCTOS = 5;

    public BolsaSupermercado() {
        productos = new ArrayList<>();
        id = ++autoincrement;
    }

    public BolsaSupermercado addProducto(T producto) {
        if (id <= MAX_PRODUCTOS)
            productos.add(producto);
        return this;
    }

    public List<T> getProductos() { return productos; }
}
