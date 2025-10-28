package vt04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2: Crear una BD para Alumnos
 * Crear Clase Alumnos (tendrá que implementar la interfaz serializable)
 * Atributos id y nombre
 * Reutilizar la Clase ConnectDB
 * Estableceremos los datos de la conexión(constructor por defecto y con parámetros)
 * Tendrá el método connectToDB; donde haremos las gestiones habituales con la bbdd
 * Crear Clase AlumnosMain
 * Crearemos objeto connect para hacer la conexión
 */
public class AlumnosMain {
	public static void main(String[] args) {
		// Creamos una lista con alumnos.
		List<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.add(new Alumno("Javi"));
		listaAlumnos.add(new Alumno("Aitor"));
		listaAlumnos.add(new Alumno("Miguel"));
		listaAlumnos.add(new Alumno("Jose"));
		listaAlumnos.add(new Alumno("Rocio"));

		// establecemos conexion con la BD.
		ConnectDB connection = new ConnectDB();
		Connection conn = connection.connectToDB();
		try {
			// Limpiamos la tabla alumnos inicialmente.
			Statement stmn0 = conn.createStatement();
			stmn0.executeUpdate("TRUNCATE TABLE `alumnos`");
			stmn0.close();

			// Creamos una consulta dinamica para establecer los valores de cada alumno.
			PreparedStatement stmn = conn.prepareStatement("INSERT INTO `alumnos` (`ID`,`nombre`) VALUES (?, ?)");

			// Recorremos la lista de alumnos y ejecutamos la consulta a la BD por cada alumno.
			for (Alumno a : listaAlumnos) {
				int index = 0;
				stmn.setInt(++index, a.getId());
				stmn.setString(++index, a.getNombre());
				stmn.executeUpdate();
			}

			// Cerramos el prepared statement
			stmn.close();

			// Ahora vamos a recuperar los datos insertados
			Statement stmn2 = conn.createStatement();

			// Ejecutamos la sentencia select a la BD y lo establecemos en un ResultSet
			ResultSet result = stmn2.executeQuery("SELECT * FROM `alumnos`");

			// Recorremos los registros del ResultSet e imprimimos los datos obtenidos
			while (result.next()) {
				System.out.println("Alumno ID: " + result.getInt("ID") + " - Nombre: " + result.getString("nombre"));
			}

			// cerramos recursos
			result.close();
			stmn2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // cerramos conexion con la bd.
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
