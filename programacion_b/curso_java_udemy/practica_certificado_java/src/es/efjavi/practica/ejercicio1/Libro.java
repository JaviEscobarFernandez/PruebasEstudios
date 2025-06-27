package es.efjavi.practica.ejercicio1;

public class Libro extends MaterialBiblioteca implements Prestable {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        super(isbn);
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        prestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getISBN() { return isbn; }
    public String getAutor() { return autor; }
    public boolean getPrestado() { return prestado; }

    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + isbn);
    }

    @Override
    public String obtenerTipoMaterial() {
        return "Libro";
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El libro " + getTitulo() + " ha sido prestado.");
            return;
        }
        System.err.println("El libro " + getTitulo() + " ya ha sido prestado previamente, no puede realizarse la accion.");
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El libro " + getTitulo() + " ha sido devuelto.");
            return;
        }
        System.err.println("El libro " + getTitulo() + " no ha sido prestado previamente, no puede realizarse la accion.");
    }
}
