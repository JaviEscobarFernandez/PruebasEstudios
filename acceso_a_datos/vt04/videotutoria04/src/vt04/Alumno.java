package vt04;

import java.io.Serializable;

public class Alumno implements Serializable {
	private int id;
	private String nombre;
	private static int ID_CONT;

	public Alumno(String nombre) {
		this.id = ++ID_CONT;
		this.nombre = nombre;
	}

	public int getId() { return id;	}
	public String getNombre() {	return nombre; }
}
