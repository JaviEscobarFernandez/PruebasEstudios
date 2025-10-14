package vt01;

/**
 * Clase para el Ejercicio 6, para poder almacenar los datos de un empleado
 */
public class Empleado {
	private int id;
	private String apellido;
	private int departamento;
	private double salario;
	
	private static int id_cont;
	
	public Empleado(String apellido, int departamento, double salario) {
		this.apellido = apellido;
		this.departamento = departamento;
		this.salario = salario;
		id = ++id_cont;
	}

	public int getId() { return id;	}
	public String getApellido() { return apellido; }
	public int getDepartamento() { return departamento; }
	public double getSalario() { return salario; }
}
