package introduccion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EjemploAsignacionPropiedadesSistema {
    public static void main(String[] args) {
        try {
            FileInputStream archivo = new FileInputStream("src/introduccion/config.propierties");
            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada","Mi valor guardado en el objeto properties");
            System.setProperties(p);

            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(...); = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));
            ps.list(System.out);
        } catch(Exception e) {
            System.err.println("Archivo no existente " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
