package introduccion;

import java.util.Properties;

public class EjemploPropiedadesSistema {
    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        System.out.println("username = " + username);

        String home = System.getProperty("user.home");
        System.out.println("home = " + home);

        String workspace = System.getProperty("user.dir");
        System.out.println("workspace = " + workspace);

        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion = " + javaVersion);

        String separador = System.getProperty("line.separator");
        String separador2 = System.lineSeparator();
        System.out.println("separador:" + separador2 + "Nueva línea.");

        Properties p = System.getProperties();
        System.out.println("Listando todas las propiedades de System.getProperties()");
        p.list(System.out);

    }
}
