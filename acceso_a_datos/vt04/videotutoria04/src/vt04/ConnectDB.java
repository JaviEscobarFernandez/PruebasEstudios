package vt04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ejercicio 1: Crear conexion a BD MySQL utilizando JDBC:
 * Crea clase ConnectDB
 * Crea constructor vacio (con conexion por defecto)
 * Crea constructor con parametros (conexion personalizada)
 * Crea metodo connectToDB() para establecer conexion con la BD
 * Crea clase Main
 */
public class ConnectDB {
	private String url;
	private String user;
	private String pass;

	public ConnectDB() {
		url = "jdbc:mysql://localhost/test";
		user = "root";
		pass = "";
	}

	public ConnectDB(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public Connection connectToDB() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
