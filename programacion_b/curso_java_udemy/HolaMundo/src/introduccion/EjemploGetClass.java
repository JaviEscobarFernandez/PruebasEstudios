package introduccion;

import java.lang.reflect.Method;

public class EjemploGetClass {
    public static void main(String[] args) {
        String texto = "Hola, ¿que tal?";

        Class strClass = texto.getClass();
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
        System.out.println("strClass = " + strClass);

        System.out.println("Listar métodos de la clase String:");
        for (Method m : strClass.getMethods()) {
            System.out.println("metodo = " + m.getName());
        }

        Integer num = 34;
        Class intClass = num.getClass();
        Class objClass = intClass.getSuperclass().getSuperclass();
        System.out.println("intClass.getSuperclass().getSuperclass() = " + intClass.getSuperclass());
        System.out.println("intClass.getSuperclass().getSuperclass() = " + intClass.getSuperclass().getSuperclass());
        
        for (Method m : objClass.getMethods()) {
            System.out.println("m.getName() = " + m.getName());
        }
    }
}
