package poo;

import java.util.*;

/*
 * Registrar empleados que serán objetos con sus atributos
 * Crearemos un procedimiento para incrementar su sueldo
 * Probando a realizar todo en un mismo fichero (no es lo recomendable)
 * Al compilar el archivo .class se dividira en dos ficheros independientes
 */

public class UsoEmpleado {

	public static void main(String[] args) {
		
		// Probando a crear un objeto Jefe (subclase de Empleados), para probar el polimorfismo
		Jefatura jefeDev = new Jefatura("Javi Escobar Fernández", 3500.00, 1992, 02, 06);
		jefeDev.setIncentivo(500.40);

		// Probando a utilizar un procedimiento para registrar empleados
		// RegistrarEmpleado("Pepito Perez", 1800.00, 2025, 01, 30, 0);
		// RegistrarEmpleado("Ana Mena", 2300.00, 2024, 10, 01, 0);
		// RegistrarEmpleado("Sergio Gonzalez", 2000.00, 2025, 01, 04, 20);

		// Creamos un array de la clase Empleado, para menajarlo de otra forma
		Empleado[] empleados = new Empleado[6];
		empleados[0] = new Empleado("Pepito Perez", 1800.00, 2025, 01, 30);
		empleados[1] = new Empleado("Ana Mena", 2300.00, 2024, 10, 01);
		empleados[2] = new Empleado("Sergio Gonzalez", 2000.00, 2025, 01, 04);
		empleados[3] = new Empleado("Felipe Fernández");
		// Creamos un nuevo empleado incluyendo al objeto jefe (subclase Jefatura)
		// para ver en accion el polimorfismo (Principio de sustitucion)
		empleados[4] = jefeDev;
		empleados[5] = new Jefatura("Alicia Abril", 3500.00, 2000, 04, 16);

		// Probando el casting, conviritiendo un objeto Empleado a Jefatura
		Jefatura jefeMarketing = (Jefatura)empleados[5];
		jefeMarketing.setIncentivo(460.30);

		// Probamos el metodo heredado de la interfaz Jefes
		System.out.println(jefeMarketing.tomarDecisiones("dar más días de vacaciones a los empleados"));
		System.out.println("");

		// Probamos el metodo heredado de la interfaz Trabajadores
		jefeDev.setBonus(25000);
		System.out.println("El jefe " + jefeDev.getNombreEmpleado() + " se le ha establecido un bonus de: " + jefeDev.getBonus() + "€\n");
		empleados[1].setBonus(4000);
		System.out.println("El empleado " + empleados[1].getNombreEmpleado() + " se le ha establecido un bonus de: " + empleados[1].getBonus() + "€\n");

		// Utilizamos el sort de arrays para ordenar los empleados.
		// El orden viene con el metodo obtenido con la interfaz llamado CompareTo
		// Obtenido al implementar la interfaz Comparable en Empleado
		// Hemos realizado el orden segun el sueldo de cada empleado de forma ascendente.
		Arrays.sort(empleados);

		// Ahora getSueldo que esta override en Jefatura, llamara a getSueldo de Jefatura en lugar al de Empleado
		// en caso de ser Jefatura o a getSueldo de Empleado si es Empleado el objeto
		// (enlazado dinamico) la JVM save a que metodo llamar dependiendo del tipo de objeto
		for (Empleado e : empleados) {
			System.out.println("Empleado con nombre: " + e.getNombreEmpleado() +
					"\n con fecha de alta: " + e.getFechaAltaEmpleado() +
					"\n con sueldo: " + e.getSueldo() +
					"€\n registrado correctamente.\n");
		}

		for (int i = 0; i < empleados.length; i++) {
			empleados[i].setAumentoSueldo(5);
		}

		System.out.println("Listando empleados despues del aumento de sueldo:\n");
		for (Empleado e : empleados) {
			System.out.println("Empleado con nombre: " + e.getNombreEmpleado() +
					"\n con fecha de alta: " + e.getFechaAltaEmpleado() +
					"\n con sueldo: " + e.getSueldo() + "€\n");
		}
	}
	
	static void RegistrarEmpleado(String nombre, double sueldo, int year, int month, int day, double incrementarSueldo) {

		Empleado empleado = new Empleado(nombre, sueldo, year, month, day);
		System.out.println("Empleado con nombre: " + empleado.getNombreEmpleado() +
				"\n con fecha de alta: " + empleado.getFechaAltaEmpleado() +
				"\n con sueldo: " + empleado.getSueldo() +
				"€\n registrado correctamente.\n");
		
		// Incrementamos el sueldo
		if (incrementarSueldo > 0) {
			empleado.setAumentoSueldo(incrementarSueldo);
			System.out.println("Incrementado el sueldo un " + incrementarSueldo + "%");
			System.out.println("al empleado con nombre: " + empleado.getNombreEmpleado() +
					"\n con fecha de alta: " + empleado.getFechaAltaEmpleado() +
					"\n con sueldo actualizado a: " + empleado.getSueldo() +
					"€ correctamente.\n");
		}
	}

}

// añadiendo la interfaz comparable a Empleado
class Empleado implements Comparable, Trabajadores {
	
	public Empleado(String nombre, double sueldo, int year, int month, int day) {
		nombre_empleado = nombre;
		sueldo_empleado = sueldo;
		// Creamos un calendario para establecer la fecha de alta (el mes empieza en 0)
		GregorianCalendar calendario = new GregorianCalendar(year, month - 1, day);
		fecha_alta_empleado = calendario.getTime();
	}

	// Probando la sobrecarga de constructores
	public Empleado(String nombre) {
		this(nombre, 1500.00, 2005, 01, 01);
	}

	// getters
	public String getNombreEmpleado() { return nombre_empleado; }
	public double getSueldo() { return sueldo_empleado; }
	public Date getFechaAltaEmpleado() { return fecha_alta_empleado; }
	// implementando el metodo de la interfaz comparable
	public int compareTo(Object o) {
		// Realizamos un cast para obtener la clase empleado del objeto
		Empleado empleado = (Empleado)o;
		double sueldoA = this.getSueldo();
		double sueldoB = empleado.getSueldo();
		// Comparamos los sueldos para comprobar si es mayor, menor o igual
		if (sueldoA < sueldoB)
			return -1;
		else if (sueldoA > sueldoB)
			return 1;
		else
			return 0;
	}
	public double getBonus() { return bonus; }

	// implementando metodo heredado de Trabajadores
	public void setBonus(double bonus) {
		
		this.bonus = Trabajadores.bonus_base + bonus;
	}

	// setters
	public void setAumentoSueldo(double pct) {
		double aumento = sueldo_empleado * pct / 100;
		sueldo_empleado += aumento;
	}
	public void setBonusInternal(double value) {
		this.bonus = value;
	}

	private String nombre_empleado;
	private double sueldo_empleado;
	private Date fecha_alta_empleado;
	private double bonus;
}

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura(String nombre, double sueldo, int year, int month, int day) {
		super(nombre, sueldo, year, month, day);
	}

	// setters
	public void setIncentivo(double valor) { incentivo = valor; }

	// interfaz heredada de Jefes
	public String tomarDecisiones(String decision) {
		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}
	// interfaz heredada de Trabajadores (que es heredada de Jefes)
	public void setBonus(double bonus) {

		double prima = 2000; // prima extra
		setBonusInternal(Trabajadores.bonus_base + bonus + prima);
	}
	// getters
	// Reemplazamos (override) la funcion de Empleado
	// llamamos a la funcion de Empleado (con super) para obtener el sueldo base y le sumamos el incentivo
	public double getSueldo() { return super.getSueldo() + incentivo; }

	private double incentivo;
}
