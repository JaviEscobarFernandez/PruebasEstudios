package libros;

public class Libro {
	// atributos
	private String isbn;
	private String autor;
	private String titulo;
	private int year;
	private String editorial;
	private int num_paginas;

	// constructor
	public Libro(String isbn, String autor, String titulo, int year, String editorial, int num_paginas) {
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.year = year;
		this.editorial = editorial;
		this.num_paginas = num_paginas;
	}

	// getters
	public String getIsbn() { return isbn; }
	public String getAutor() { return autor; }
	public String getTitulo() { return titulo; }
	public int getYear() { return year; }
	public String getEditorial() { return editorial; }
	public int getNum_paginas() { return num_paginas; }

	// setters
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setAutor(String autor) { this.autor = autor; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public void setYear(int year) { this.year = year; }
	public void setEditorial(String editorial) { this.editorial = editorial; }
	public void setNum_paginas(int num_paginas) { this.num_paginas = num_paginas; }

	// metodos adicionales
	public void mostrarLibro() {
		System.out.println("Mostrando información del libro:");
		System.out.println("ISBN: " + getIsbn());
		System.out.println("Autor: " + getAutor());
		System.out.println("Título: " + getTitulo());
		System.out.println("Año de publicación: " + getYear());
		System.out.println("Editorial: " + getEditorial());
		System.out.println("Número de páginas: " + getNum_paginas());
		System.out.println();
	}
}
