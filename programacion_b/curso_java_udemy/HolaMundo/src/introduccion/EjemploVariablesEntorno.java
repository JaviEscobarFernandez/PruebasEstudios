package introduccion;

import java.util.Map;

public class EjemploVariablesEntorno {
    public static void main(String[] args) {
        Map<String, String> variableEnviroment = System.getenv();
        System.out.println("Variables de entorno del sistema = " + variableEnviroment);

        System.out.println("--------- Listando variables del entorno del sistema -----------");
        for (String key : variableEnviroment.keySet()) {
            System.out.println(key + " => " + variableEnviroment.get(key));
        }

        String username = System.getenv("USERNAME");
        System.out.println("username = " + username);

        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("javaHome = " + javaHome);

        String tempDir = System.getenv("TEMP");
        System.out.println("tempDir = " + tempDir);
        
        String path = System.getenv("Path");
        System.out.println("path = " + path);
        String path2 = variableEnviroment.get("Path");
        System.out.println("path2 = " + path2);
    }
}
