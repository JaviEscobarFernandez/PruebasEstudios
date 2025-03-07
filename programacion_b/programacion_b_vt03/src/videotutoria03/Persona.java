package videotutoria03;

public class Persona {
	// atributos
	private String nombre;
	private String apellido1;
	private String apellido2;
	private char sexo;
	private int edad;
	private String direccion;

	// constructor
	public Persona(String nombre, String ap1, String ap2, char sexo, int edad, String direccion) {
		this.nombre = nombre;
		this.apellido1 = ap1;
		this.apellido2 = ap2;
		this.sexo = sexo;
		this.edad = edad;
		this.direccion = direccion;
	}

	// getters
	public String getNombre() { return nombre; }
	public String getApellidos() { return apellido1 + " " + apellido2; }
	public char getSexo() { return sexo; }
	public int getEdad() { return edad; }
	public String getDireccion() { return direccion; }

	// setters
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellidos(String ap1, String ap2) {
		this.apellido1 = ap1;
		this.apellido2 = ap2;
	}
	public void setSexo(char sexo) { this.sexo = sexo; }
	public void setEdad(int edad) { this.edad = edad; }
	public void setDireccion(String direccion) { this.direccion = direccion; }

	// metodos extra
	public void mostrarDatos() {
		System.out.println("Nombre: " + getNombre());
		System.out.println("Apellidos: " + getApellidos());
		System.out.println("Sexo: " + getSexo());
		System.out.println("Edad: " + getEdad());
		System.out.println("Dirección: " + getDireccion());
	}
	public void mayorEdad() {
		if (getEdad() >= 18) {
			System.out.println(getNombre() + " es mayor de edad.");
			return;
		}
		System.out.println(getNombre() + " NO es mayor de edad.");
	}
}
