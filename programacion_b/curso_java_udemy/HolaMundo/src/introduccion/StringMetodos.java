package introduccion;

public class StringMetodos {
    public static void main(String[] args) {
        String nombre = "Javi";
        System.out.println("cantidad de caracteres de " + nombre + ": " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Javi\") = " + nombre.equals("Javi"));
        System.out.println("nombre.equals(\"javi\") = " + nombre.equals("javi"));
        System.out.println("nombre.equalsIgnoreCase(\"javi\") = " + nombre.equalsIgnoreCase("javi"));
        System.out.println("nombre.compareTo(\"Javi\") = " + nombre.compareTo("Javi"));
        System.out.println("nombre.compareTo(\"Java\") = " + nombre.compareTo("Java"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(nombre.length() - 1) = " + nombre.charAt(nombre.length() - 1));

        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(0, 2) = " + nombre.substring(0, 2));
        System.out.println("nombre.substring(1, nombre.length()) = " + nombre.substring(1, nombre.length()));

        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.replace(\"a\", \".\") = " + trabalenguas.replace("a", "."));
        System.out.println("trabalenguas = " + trabalenguas);
        System.out.println("trabalenguas.indexOf(\"a\") = " + trabalenguas.indexOf("a"));
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        System.out.println("trabalenguas.IndexOf('z') = " + trabalenguas.lastIndexOf('z'));
        System.out.println("trabalenguas.contains(\"bal\") = " + trabalenguas.contains("bal"));
        System.out.println("trabalenguas.startsWith(\"tr\") = " + trabalenguas.startsWith("tr"));
        System.out.println("trabalenguas.endsWith(\"s\") = " + trabalenguas.endsWith("s"));
        trabalenguas = " trabalenguas ";
        System.out.println("trabalenguas.trim() = " + trabalenguas.trim());

        trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());

        char[] arrayChar = trabalenguas.toCharArray();
        for (char c : arrayChar) {
            System.out.print(" " + c);
        }
        System.out.println("");
        for (int i = 0; i < arrayChar.length; i++) {
            System.out.println("arrayChar[i] = " + arrayChar[i]);
        }

        System.out.println("trabalenguas.split(\"a\") = " + trabalenguas.split("a"));

        String[] arrayString = trabalenguas.split("a");
        for (String s : arrayString) {
            System.out.print(" " + s);
        }
        System.out.println("");
        for (int i = 0; i < arrayString.length; i++) {
            System.out.println("arrayString[i] = " + arrayString[i]);
        }

        String archivo = "algun.archivo.pdf";
        String[] archivoString = archivo.split("\\."); // [.]
        for (String s : archivoString) {
            System.out.println("s = " + s);
        }
        System.out.println("La extension del archivo es: " + archivoString[archivoString.length - 1]);
    }
}
