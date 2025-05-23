package ejercicio01;

/*
 * Ejercicio Crear clase libro con atributos ISBN, titulo, autor, numero paginas y estado (devuelto o prestado)
 * Crear constructor vacio y otro sobrecargado, encapsular atributos, utilizar los getters y setters necesarios
 * crear metodo imprimir para imprimir el libro en base a un precio por pagina y el numero de paginas
 * crear metodo para mostrar la informacion del libro y otros dos metodos para prestar y devolver el libro,
 * solo realizaran la accion si el libro esta en el estado contrario.
 * Crear metodo para comparar si el libro es el mismo o no (cada libro tiene su propio ISBN)
 */
public class Main {

    public static void main(String[] args) {
        Libro libro1 = new Libro("1234-ABC", "El libro gordo de petete", 400, "Manuel García Ferré");
        libro1.mostrarInformacion();
        libro1.devolver();
        libro1.prestar();
        libro1.devolver();
        libro1.imprimir();
        if (libro1.equals(libro1))
            System.out.println("Es el mismo libro.");
        else
            System.out.println("No son iguales los libros.");
        Libro libro2 = null;
        if (libro1.equals(libro2))
            System.out.println("Es el mismo libro.");
        else
            System.out.println("No son iguales los libros.");
        libro2 = new Libro();
        libro2.mostrarInformacion();
        if (libro2.equals(libro1))
            System.out.println("Es el mismo libro.");
        else
            System.out.println("No son iguales los libros.");
    }

}
