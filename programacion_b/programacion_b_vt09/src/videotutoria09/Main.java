package videotutoria09;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ConnectDB conexion = new ConnectDB();
        try {
            conexion.connectToDB();
        } catch(SQLException e) {
            System.err.println("ERROR: no se ha podido conectar a la BBDD");
            e.printStackTrace();
        }

    }

}
