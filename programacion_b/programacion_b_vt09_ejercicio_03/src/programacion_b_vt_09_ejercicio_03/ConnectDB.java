package programacion_b_vt_09_ejercicio_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private final String DBPATH;
    private final String DBUSER;
    private final String DBPASS;

    // Constructor donde inicializamos las variables estaticas para la conexion a la BD
    public ConnectDB() {
        this.DBPATH = "jdbc:oracle:thin:@localhost:1521/XE"; // Ubicacion del SGBD
        this.DBUSER = "user_prueba";
        this.DBPASS = "pass_prueba";
    }

    // Metodo que devuelve un tipo Connection, estableciendo una conexion a la BD
    // Delegamos el control de excepciones donde se llame el metodo, en lugar de manejarlo aqui.
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBPATH, DBUSER, DBPASS);
    }
}
