package es.efjavi.catalogo.producto;

import java.util.Date;

public class Comic extends Libro {
    private String personaje;

    public Comic(int precio, Date fechaPublicacion, String autor, String titulo, String editorial, String personaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() { return personaje; }

    @Override
    public double getPrecioVenta() { return getPrecio() ; }

    @Override
    public String getDatos() {
        return super.getDatos() + "\nPersonaje: " + getPersonaje();
    }

    @Override
    public String toString() {
        return "Tipo: Comic\n" + getDatos();

    }
}
