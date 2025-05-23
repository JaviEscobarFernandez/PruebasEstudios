package programacion_b_vt_09_ejercicio_03;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    final static String TABLE_NAME = "VT_09_ALUMNOS"; // Declaramos en una constante el nombre de la tabla que vamos a manipular.

    public static void main(String[] args) {
        // Generamos una conexion con la BD
        ConnectDB conect = new ConnectDB();
        try {
            // Obtenemos la conexion con la BD
            Connection conexionDB = conect.getConnection();

            // Generamos la consulta en un statement
            String query = "SELECT id, nombre FROM " + TABLE_NAME;
            Statement st = conexionDB.createStatement();

            // Ejecutamos la consulta y la almacenamos su resultado
            ResultSet result = st.executeQuery(query);

            // Creamos un ArrayList de alumnos y obtenemos los datos del resultado almacenado previamente.
            // Generando un alumno por cada resultado obtenido, iterandolo.
            ArrayList<Alumno> alumnos = new ArrayList<>();
            while (result.next()) {
                // Utilizamos result.getInt y result.getString para obtener cada columna correspondiente.
                // Se puede especificar la columna en cuestion (en orden a razon de la query) con un numero (empezando por el 1)
                // O introduciendo un string con el nombre de la columna especificamente.
                Alumno alumno = new Alumno(result.getInt(1), result.getString("nombre"));
                alumnos.add(alumno);
            }

            // Imprimimos la lista de alumnos almacenados cargados de la BD.
            for (Alumno a : alumnos) {
                System.out.println(a.toString());
            }

            // Cerramos las conexiones con la BD al finalizar las operaciones
            result.close();
            st.close();
            conexionDB.close();

            // Explicar esto por si acaso en un ejemplo aparte.
            /*
             * Este codigo carga explicitamente el driver JDBC en tiempo de ejecucion.
             * Era necesario en versiones antiguas de Java y JDBC (por ejemplo, JDBC 3 o anteriores).
             * Si no lo hacias, Java no sabia que driver usar para conectarse.
             * 
             * Porque a partir de JDBC 4 (Java 6 en adelante), se introdujo el auto-registro de drivers. Es decir:
             * Si el driver JDBC esta en el classpath (por ejemplo, incluido como .jar en tu proyecto),
             * Java lo detecta automaticamente sin necesidad de usar Class.forName(...).
             */
            final String DRIVER = "com.mysql.jdbc.Driver"; 
            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                System.err.println(e);
            }
            // Anotar tambien los metodos createStatement que no utiliza parametros
            // Y que executeQuery requiere como parametros el string de la consulta
            // Y alguna cosilla asi.
        } catch (SQLException e) {
            // Manejamos las excepciones en caso de error.
            System.err.println("ERROR: no se ha podido establecer la conexion con la BD.");
            System.err.println(e);
            System.err.println(e.getStackTrace());
            
        }
    }
}
