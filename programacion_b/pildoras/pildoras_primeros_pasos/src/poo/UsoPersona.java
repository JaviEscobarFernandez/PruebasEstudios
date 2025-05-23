package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {

		Persona[] personas = new Persona[2];
		personas[0] = new Empleado2("Jose Carmona", 2100.00, 2003, 02, 21);
		personas[1] = new Alumno("Marcos Llorente", "Ingenieria informática");

		for (Persona p : personas) {
			System.out.println("Persona creada correctamente:");
			// Estamos llamando al metodo abstracto y dependiendo de la subclase llama a un metodo y otro
			System.out.println(p.getDescripcion() + "\n");
		}
	}
}

// Probando a crear una clase abstracta, para crear un metodo abstracto
// Para forzar a que el metodo se sobreescriba en cada nueva subclase.
abstract class Persona {
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	// getters
	public String getNombre() { return nombre; }
	public abstract String getDescripcion();

	private String nombre;
}

class Empleado2 extends Persona {
	
	public Empleado2(String nombre, double sueldo, int year, int month, int day) {

		super(nombre);
		sueldo_empleado = sueldo;
		// Creamos un calendario para establecer la fecha de alta (el mes empieza en 0)
		GregorianCalendar calendario = new GregorianCalendar(year, month - 1, day);
		fecha_alta_empleado = calendario.getTime();
		id_empleado = next_id_empleado;
		next_id_empleado++;
	}

	// getters
	public String getDescripcion() {
		return "El empleado " + getNombre() + " con ID: " + getIdEmpleado() + " tiene un sueldo de: " + getSueldo();
	}
	public int getIdEmpleado() { return id_empleado; }
	public double getSueldo() { return sueldo_empleado; }
	public Date getFechaAltaEmpleado() { return fecha_alta_empleado; }

	// setters
	public void setAumentoSueldo(double pct) {
		double aumento = sueldo_empleado * pct / 100;
		sueldo_empleado += aumento;
	}

	private double sueldo_empleado;
	private Date fecha_alta_empleado;
	private int id_empleado;
	private static int next_id_empleado = 1;
}

class Alumno extends Persona {
	
	public Alumno(String nombre, String estudios) {
		
		super(nombre);
		estudios_alumno = estudios;
	}

	// getters
	public String getDescripcion() {
		return "El alumno " + getNombre() + " esta cursando: " + getEstudios();
	}
	public String getEstudios() { return estudios_alumno; }

	private String estudios_alumno;
}