package codigo;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    final static String TABLE_NAME = "VT_09_ALUMNOS"; // constante que representar el nombre de la BD usada en la prueba

    public static void main(String[] args) {
        // Generamos una conexion con la BD, instanciamos primero la clase creada
        ConnectDB connection = new ConnectDB();
        // Como getConnection delega SQLException, lo gestionamos aqui
        try {
            // Obtenemos la conexion con la BD utilizando el metodo de la clase instanciada
            Connection connectionDB = connection.getConnection();
            System.out.println("Establecida conexion a la BD correctamente.");
            registrarUsuarios(connectionDB); // metodo para registrar usuarios en la BD
            cargarUsuarios(connectionDB); // metodo para cargar los usuarios registrados en la BD
            connectionDB.close(); // Al finalizar se debe cerrar la conexion con la BD
        } catch(SQLException e) {
            // En caso de dar un error, manejamos aqui la excepcion
            System.err.println("ERROR: No se ha podido establecer la conexion con la BD.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void registrarUsuarios(Connection connectionDB) throws SQLException {
        String query = "TRUNCATE TABLE " + TABLE_NAME; // sentencia SQL para vaciar la tabla inicialmente
        Statement statement = connectionDB.createStatement(); // Creamos un statement para ejecutar la sentencia
        statement.executeUpdate(query); // Ejecutamos la sentencia

        query = "INSERT INTO " + TABLE_NAME + " (id, nombre) VALUES (?, ?)"; // Sentencia SQL para insertar datos en la tabla
        // Generamos unos alumnos de prueba (Array de strings con los nombres de los alumnos de prueba)
        String[] nombres = new String[] { "Javi", "Miguel", "Aitor", "Jose", "Alex" };
        // Creamos un preparedStatement para realizar una consulta "dinamica" con valores de los parametros indicados.
        PreparedStatement preparedSt = connectionDB.prepareStatement(query);
        // Recorremos el array de nombres de alumnos
        for (int i = 0; i < nombres.length; i++) {
            preparedSt.setInt(1, (i + 1)); // Establecemos la id del alumno (posicion del array + 1)
            preparedSt.setString(2, nombres[i]); // Establecemos el nombre del alumno
            preparedSt.executeUpdate(); // Ejecutamos la sentencia insert para cada alumno
        }

        // Una vez finalizadas las operaciones, cerramos los statements (la conexion a BD se cierra en el metodo principal)
        System.out.println("Registrados usuarios correctamente");
        preparedSt.close();
        statement.close();
    }

    private static void cargarUsuarios(Connection connectionDB) throws SQLException {
        System.out.println("Cargando lista de alumnos de la BD...");
        String query = "SELECT id, nombre FROM " + TABLE_NAME; // Consulta SQL para recuperar la informacion de los alumnos
        Statement statement = connectionDB.createStatement(); // Generamos un statement para ejecutar la sentencia
        ResultSet result = statement.executeQuery(query); // Ejecutamos y almacenamos la sentencia en un ResultSet
        // Creamos un arraylist de Alumno para instanciar los alumnos en base a los datos recuperados de la BD con la consulta previa
        ArrayList<Alumno> alumnos = new ArrayList<>();
        // iteramos el ResultSet igual que si fuese un Iterator, cada linea es un registro en la tabla
        while (result.next()) {
            // Instanciamos el alumno con los datos obtenidos y se añade al arraylist dicho objeto instanciado
            Alumno alumno = new Alumno(result.getInt("id"), result.getString("nombre"));
            alumnos.add(alumno);
        }
        // Una vez cargados los alumnos de la BD, recorremos el arraylist e imprimimos su informacion
        System.out.println("lista de alumnos cargada correctamente:");
        for (Alumno a : alumnos) {
            System.out.println(a.toString());
        }
        // Una vez finalizadas las operaciones, cerramos los Statements y ResultSet (la conexion a BD se cierra en el metodo principal)
        result.close();
        statement.close();
    }
}
