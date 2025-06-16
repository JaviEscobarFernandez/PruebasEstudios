package es.efjavi.catalogo.producto;

import java.util.Date;

public class Libro extends Producto implements ILibro {
    private Date fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    public Libro(int precio, Date fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    @Override
    public Date getFechaPublicacion() { return fechaPublicacion; }

    @Override
    public String getAutor() { return autor; }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getEditorial() { return editorial; }

    @Override
    public double getPrecioVenta() { return getPrecio() ; }

    @Override
    public String getDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de publicación: ").append(getFechaPublicacion().toString()).append("\n")
                .append("Autor: ").append(getAutor()).append("\n")
                .append("Título: ").append(getTitulo()).append("\n")
                .append("Editorial: ").append(getEditorial()).append("\n")
                .append("Precio de venta: ").append(getPrecioVenta()).append("€");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Tipo: Libro\n" + getDatos();
    }
}
