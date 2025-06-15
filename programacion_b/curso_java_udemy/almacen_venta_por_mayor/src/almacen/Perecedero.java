package almacen;

import java.util.Date;

public class Perecedero extends Producto {
    private Date fechaCaducidad;

    public Perecedero(String nombre, double precio, Date fechaCaducidad) {
        super(nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() { return fechaCaducidad; }

    @Override
    public String toString() {
        return "Producto Tipo: Perecedero\n" +
                super.toString() + "\nFecha de Caducidad: " + getFechaCaducidad();
    }
}
