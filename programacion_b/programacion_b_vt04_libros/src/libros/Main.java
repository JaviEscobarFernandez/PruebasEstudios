package libros;

import java.util.Scanner;

/*
 * Ejercicio propuesto en videotutoria 04.
 * "Crea un proyecto en Java que represente una clase Libro que tenga los siguientes atributos (son los creados en la clase Libro).
 * Define al menos 3 objetos de esta clase
 * Crea un método que instancie 3 libros
 * Dos de ellos pasando los datos a través del constructor
 * El último, solicitando los datos por teclado al usuario."
 */

public class Main {

	public static void main(String[] args) {
		Libro libro1 = new Libro("0-7645-2641-3", "Perico", "El cielo", 1978, "Anaya", 1246);
		Libro libro2 = new Libro("0-2431-6452-2", "Mar", "La tempestad", 2002, "Pegassus", 567);
		Libro libro3 = crearLibro();

		libro1.mostrarLibro();
		libro2.mostrarLibro();
		libro3.mostrarLibro();
	}

	public static Libro crearLibro() {
		// Instanciamos scanner para solicitar texto por consola al usuario.
		Scanner sc = new Scanner(System.in);
		// ISBN
		System.out.print("Introduce el ISBN: ");
		String isbn = sc.nextLine();
		// Autor
		System.out.print("Introduce el Autor: ");
		String autor = sc.nextLine();
		// Titulo
		System.out.print("Introduce el Título: ");
		String titulo = sc.nextLine();
		// Año publicacion
		System.out.print("Introduce el Año de publicación: ");
		int year = sc.nextInt();
		sc.nextLine(); // Utilizamos nextLine() despues de nextInt() para vaciar el buffer
		// Editorial
		System.out.print("Introduce la Editorial: ");
		String editorial = sc.nextLine();
		// Numero de paginas
		System.out.print("Introduce el Número de páginas: ");
		int num_paginas = sc.nextInt();
		sc.nextLine(); // Utilizamos nextLine() despues de nextInt() para vaciar el buffer
		// Instanciamos libro con los datos recogidos y lo enviamos como valor de retorno
		Libro libro = new Libro(isbn, autor, titulo, year, editorial, num_paginas);
		return libro;
	}
}
