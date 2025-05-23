package poo;

public class Pruebas {

	public static void main(String[] args) {

		// Creamos un objeto para cada empleado
		Empleados empleado1 = new Empleados("Dani");
		Empleados empleado2 = new Empleados("Rosa");
		Empleados empleado3 = new Empleados("Martín");
		Empleados empleado4 = new Empleados("Paquita");

		// Establecemos una nueva seccion a ciertos empleados
		empleado1.setSeccion("Recursos Humanos");
		empleado4.setSeccion("Desarrollo");

		// Imprimimos por consola la información de los empleados
		System.out.println(empleado1.devuelveDatos());
		System.out.println(empleado2.devuelveDatos());
		System.out.println(empleado3.devuelveDatos());
		System.out.println(empleado4.devuelveDatos());

		System.out.println(Empleados.getNextId());
	}
}

class Empleados {

	public Empleados(String nombre) {

		nombreEmpleado = nombre;
		seccion = "Administración";
		id = next_id;
		next_id++;
	}
	
	// Setters
	// public void setNombre(String nombre) { nombreEmpleado = nombre; } // Al ser constante (final) no puede modificarse
	public void setSeccion(String seccion) { this.seccion = seccion; }

	// Getters
	public String devuelveDatos() {

		return "Empleado con ID: " + id + " y nombre: " + nombreEmpleado + " en sección: " + seccion;
	}
	public static String getNextId() {
		
		return "El último ID libre: " + next_id;
	}

	private final String nombreEmpleado;
	private String seccion;
	private int id;
	// Declaramos una variable estatica y la inicializamos a 1.
	// De esta manera no se crea una copia en cada creacion del objeto empleado
	// Y la utilizaremos para establecer el id, incrementando el contador en cada asignacion.
	private static int next_id = 1;
}
