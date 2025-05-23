package videotutoria09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {
    private final String BBDD;
    private final String USER;
    private final String PASS;

    public ConnectDB() {
        this.BBDD = "jdbc:oracle:thin:@localhost:1521/XE"; // Ubicacion del SGBD
        this.USER = "user_prueba";
        this.PASS = "pass_prueba";
    }

    public void connectToDB() throws SQLException {
        Connection connect = DriverManager.getConnection(BBDD, USER, PASS);
        Statement sentencia = connect.createStatement();

        final String TABLE_NAME = "VT_09_ALUMNOS";
        String sqlQuery = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + TABLE_NAME + "'";
        // Ejecutamos la sentencia para comprobar si la tabla existe y almacenamos el resultado
        ResultSet result = sentencia.executeQuery(sqlQuery);

        // Avanzamos el cursor al resultado
        result.next();

        // Comprobamos si la tabla existe (count > 0)
        if (result.getInt(1) > 0) { // Si la tabla existe, la borramos
            sqlQuery = "DROP TABLE " + TABLE_NAME;
            sentencia.executeUpdate(sqlQuery);
            System.out.println("Tabla eliminada: " + TABLE_NAME);
        } else {
            System.out.println("La tabla no existe, se omite su borrado: " + TABLE_NAME);
        }

        // Crear la tabla
        sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                "id NUMBER(10) PRIMARY KEY," +
                "nombre VARCHAR2(50) NOT NULL" +
                ")";
        // Ejecutamos la sentencia para la creacion de la tabla.
        sentencia.executeUpdate(sqlQuery);
        System.out.println("Tabla creada con exito: " + TABLE_NAME);

        // Insertamos algunos alumnos en la tabla (Utilizando prepared statement)
        String[] nombres = new String[] { "Javi", "Miguel", "Aitor", "Jose", "Alex" };
        sqlQuery = "INSERT INTO " + TABLE_NAME + " (id, nombre) VALUES (?,?)";
        PreparedStatement preparedSt = connect.prepareStatement(sqlQuery);
        for (int i = 0; i < nombres.length; i++) {
            preparedSt.setInt(1, (i + 1));
            preparedSt.setString(2, nombres[i]);
            preparedSt.executeUpdate();
        }

        // Ahora seleccionamos con una consulta a la BD a los alumnos y los almacenamos en el result set
        sqlQuery = "SELECT id, nombre FROM " + TABLE_NAME;
        result = sentencia.executeQuery(sqlQuery);

        // Creamos un arraylist de la clase Alumno, instanciamos los alumnos seleccionados y los añadimos a la lista
        ArrayList<Alumno> alumnos = new ArrayList<>();
        while(result.next()) {
            Alumno alu = new Alumno(result.getInt("id"), result.getString("nombre"));
            alumnos.add(alu);
        }

        // imprimimos la lista de alumnos almacenada
        System.out.println("La lista de alumnos insertados es:");
        for (Alumno a : alumnos) {
            System.out.println(a.toString());
        }

        // Cerrar recursos
        result.close();
        preparedSt.close();
        sentencia.close();
        connect.close();
    }
}
