package vt01;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Ejercicio 6: Crea un programa en Java que inserte datos de empleados en un fichero aleatorio.
 * Indicando apellido, departamento y salario. Para cada empleado se insertara un identificador
 * (mayor que cero) y coincidira con el indice + 1 que recorren los arrays
 * Identidicador = 4 bytes entero
 * Apellido = 10 caracteres UNICODE, cada caracter 2 bytes (20 bytes en total)
 * Departamento 4 bytes entero
 * Salario 8 bytes double
 * 
 * Ejercicio 6.1: Crea un programa en Java que muestre los datos introducidos en el ejercicio anterior.
 * El posicionamiento empezara a recorrer es 0 y para recuperar datos hay que añadir 36 a la variable del posicionamiento.
 * 
 * Ejercicio 6.2: Crea un programa en Java que consulte los datos de un empleado en particular del fichero creado en el ejercicio anterior.
 * Por ejemplo: busca empleado con ID 5
 */
public class Ejercicio6 {

	private static final int EMPLEADO_SIZE = 36; // 4 id + 20 apellido + 4 departamento + 8 salario (36 bytes)
	private static final int APELLIDO_MAX_SIZE = 10; // maximo 10 caracteres

	public static void main(String[] args) {
		// Creamos el directorio y el fichero, por si no lo estan
		Path fichero = null;
		try {
			Path directorio = Paths.get("Ejercicio6");
			Files.createDirectories(directorio);
			fichero = Paths.get(directorio.toString(), "Empleados.bin");
			Files.createFile(fichero);
		} catch (IOException e) {
			// e.printStackTrace();
		}
		
		
		Scanner sc = new Scanner(System.in);

		// Menu para elegir que accion realizar de los tres puntos del ejercicio
		String opcion = "";
		try {
			do {
				System.out.println("---------------");
				System.out.println("1 - Registrar empleado");
				System.out.println("2 - Listar empleados");
				System.out.println("3 - Listar empleado por ID");
				System.out.println("4 - Salir");
				opcion = sc.nextLine();
				
				switch (opcion) {
					case "1":
						// Utilizo clase empleado para almacenar los datos
						Empleado e = crearEmpleado(sc);
						registrarEmpleado(e, fichero);
						break;
					case "2":
						listarEmpleados(fichero);
						break;
					case "3":
						System.out.println("Introduce su identificador");
						listarEmpleado(Integer.parseInt(sc.nextLine()), fichero);
						break;
					case "4":
						System.out.println("Finalizando...");
						break;
					default:
						System.err.println("ERROR: Dato introducido no válido.");
						break;
				}
			} while (!opcion.equalsIgnoreCase("4"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	// Solicitamos los datos e instanciamos un objeto del tipo empleado y lo retornamos como valor
	private static Empleado crearEmpleado(Scanner sc) {
		String apellido = "";
		int departamento = 0;
		double salario = 0;
		
		System.out.println("Introduce el apellido del empleado: ");
		apellido = sc.nextLine();
        // Rellenar el apellido con espacios si es más corto de 10 caracteres
        if (apellido.length() > APELLIDO_MAX_SIZE) {
            apellido = apellido.substring(0, APELLIDO_MAX_SIZE); // Cortar si es demasiado largo
        } else {
            // Rellenar con espacios hasta 10 caracteres
            while (apellido.length() < APELLIDO_MAX_SIZE) {
                apellido += " ";
            }
        }
		System.out.println("Introduce el departamento del empleado: ");
		departamento = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el salario del empleado: ");
		salario = Double.parseDouble(sc.nextLine());

		Empleado e = new Empleado(apellido, departamento, salario);
		return e;
	}

	// Registramos en el fichero el empleado instanciado previamente con los datos recogidos del usuario.
	private static void registrarEmpleado(Empleado e, Path fichero) throws IOException {
		// Establecemos la variable para fijar la posicion del puntero para no reemplazar al empleado registrado previamente
		// la id de empleado -1 y multiplicado por el tamaño maximo que va a ocupar su informacion.
		long posicion = (long) (e.getId() - 1) * EMPLEADO_SIZE;
		
		// abrimos el flujo de acceso aleatorio
		RandomAccessFile ra = new RandomAccessFile(fichero.toString(), "rw");
		// posicionamos el puntero
		ra.seek(posicion); 
		// escribimos los datos
		ra.writeInt(e.getId());
		ra.writeChars(e.getApellido());
		ra.writeInt(e.getDepartamento());
		ra.writeDouble(e.getSalario());
		// cerramos el flujo
		ra.close();
	}

	// Leemos el fichero con acceso aleatorio e imprimimos su datos para listar a los empleados registrados
	private static void listarEmpleados(Path fichero) throws IOException {
		RandomAccessFile ra = new RandomAccessFile(fichero.toString(), "r");
		// Obtenemos el tamaño maximo del fichero, para recorrerlo en un bucle
		long sizeFichero = ra.length();
		// Si el tamaño es 0 no hace falta.
		if (sizeFichero == 0) {
			System.out.println("El fichero esta vacio, no se pueden listar empleados.");
			return;
		}

		// Recorremos el fichero en bloques de 36 bytes para recorrer empleado a empleado
		for (long posicion = 0; posicion < sizeFichero; posicion += EMPLEADO_SIZE) {
			// Establecemos el puntero en la posicion correspondiente (se va incrementando de 36 en 36)
			ra.seek(posicion);
			// obtenemos inicialmente la identificacion del empleado
			int id = ra.readInt();
			// obtenemos el apellido, caracter a caracter 
			String apellido = ""; // Longitud del apellido son 10 caracteres
			for (int i = 0; i < APELLIDO_MAX_SIZE; i++) {
				apellido += ra.readChar();
			}
			apellido = apellido.trim(); // Eliminar los espacios de relleno
			// almacenamos seguidamente el departamento
			int departamento = ra.readInt();
			// y finalmente almacenamos el salario
			double salario = ra.readDouble();
			// imprimimos los datos del empleado que hemos recogido del fichero
            System.out.println("ID: " + id + " | Apellido: " + apellido + " | Dpto: " + departamento + " | Salario: " + salario);
		}
		
		// cerramos el flujo
		ra.close();
	}
	
	// Buscamos a un empleado concreto por su Identificador, es el mismo metodo de busqueda que el anterior
	// Solo imprimimos si el identificador coincide con el que se busca
	private static void listarEmpleado(int identificador, Path fichero) throws IOException {
		RandomAccessFile ra = new RandomAccessFile(fichero.toString(), "r");
		long sizeFichero = ra.length();
		if (sizeFichero == 0) {
			System.out.println("El fichero esta vacio, no se pueden listar empleados.");
			return;
		}

		String empleado = "";
		for (long posicion = 0; posicion < sizeFichero; posicion += EMPLEADO_SIZE) {
			ra.seek(posicion);
			int id = ra.readInt();
			if (id != identificador)
				continue;

			String apellido = ""; // Longitud del apellido son 10 caracteres
			for (int i = 0; i < 10; i++) {
				apellido += ra.readChar();
			}
			apellido = apellido.trim(); // Eliminar los espacios de relleno
			
			int departamento = ra.readInt();
			
			double salario = ra.readDouble();
			
            empleado = "ID: " + id + " | Apellido: " + apellido + " | Dpto: " + departamento + " | Salario: " + salario;
            break;
		}
	
		if (empleado.isEmpty())
			System.out.println("Empleado no localizado");
		else
			System.out.println(empleado);

		ra.close();
	}
}
