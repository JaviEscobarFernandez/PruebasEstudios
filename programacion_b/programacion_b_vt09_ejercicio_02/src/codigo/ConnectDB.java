package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private final String BBDD;
    private final String USER;
    private final String PASS;

    public ConnectDB() {
        this.BBDD = "jdbc:oracle:thin:@localhost:1521/XE"; // Ubicacion del SGBD
        this.USER = "user_prueba";
        this.PASS = "pass_prueba";
    }

    public Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection(BBDD, USER, PASS);
        return connect;
    }
}
