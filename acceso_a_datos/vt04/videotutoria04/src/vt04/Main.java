package vt04;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		ConnectDB connection = new ConnectDB();
		Connection conn = connection.connectToDB();
		try {
			Statement stmn = conn.createStatement();
			stmn.executeUpdate("DROP TABLE IF EXISTS `prueba`;");
			stmn.executeUpdate("CREATE TABLE prueba ("
					+ "    ID int PRIMARY KEY,"
					+ "    nombre varchar(255))");
			stmn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
