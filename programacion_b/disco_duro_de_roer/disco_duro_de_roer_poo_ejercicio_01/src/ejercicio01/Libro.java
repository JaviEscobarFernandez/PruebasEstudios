package ejercicio01;

public class Libro {
    private String ISBN;
    private String titulo;
    private int numPaginas;
    private String autor;
    private boolean prestado;
    private final double PRECIO_HOJA = 0.16;

    public Libro() {
        ISBN = "test";
        titulo = "default";
        numPaginas = 500;
        autor = "anonimo";
        prestado = false;
    }

    public Libro(String ISBN, String titulo, int numPaginas, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.autor = autor;
        prestado = false;
    }

    public String getISBN() { return ISBN; }
    public String getTitulo() { return titulo; }
    public int getNumPaginas() { return numPaginas; }
    public String getAutor() { return autor; }
    public boolean getPrestado() { return prestado; }

    public void setPrestado(boolean p) { prestado = p; }

    public void prestar() {
        if (getPrestado()) {
            System.out.println("El libro: " + getTitulo() + ", ya ha sido prestado actualmente, no se puede realizar la acción");
            return;
        }
        setPrestado(true);
        System.out.println("El libro: " + getTitulo() + ", acaba de pasar a estado prestado correctamente.");
    }

    public void devolver() {
        if (!getPrestado()) {
            System.out.println("El libro: " + getTitulo() + ", ya no esta prestado actualmente, no se puede realizar la acción");
            return;
        }
        setPrestado(false);
        System.out.println("El libro: " + getTitulo() + ", acaba de pasar a estado devuelto correctamente.");
    }

    public void imprimir() {
        double precio = getNumPaginas() * PRECIO_HOJA;
        System.out.println("El libro: " + getTitulo() + ", va a ser impreso, su precio es de: " + precio + "€");
    }

    public void mostrarInformacion() {
        System.out.println("ISBN: " + getISBN());
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Número de páginas: " + getNumPaginas());
        System.out.println("Estado: " + (getPrestado() ? "Prestado" : "Devuelto"));
    }

    public boolean equals(Libro libro2) {
        if (libro2 == null) {
            System.err.println("ERROR: No hay un objeto válido que comparar.");
            return false;
        }

        if (libro2.getISBN() != this.getISBN())
            return false;
            
        return true;
    }
}
