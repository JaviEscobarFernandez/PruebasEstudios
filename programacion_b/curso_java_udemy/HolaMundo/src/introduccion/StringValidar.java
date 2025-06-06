package introduccion;

public class StringValidar {
    public static void main(String[] args) {
        String curso = null;
        boolean isNull = curso == null;
        System.out.println("isNull = " + isNull);
        System.out.println(curso);

        if (isNull)
            curso = "Programación Java";
        System.out.println(curso.toUpperCase());

        curso = "";
        boolean estaVacio = curso.length() == 0;
        if (!estaVacio)
            System.out.println(curso.toUpperCase());
        else
            curso = "Programación Java";

        if (!curso.isEmpty())
            System.out.println(curso);

        curso = " ";
        if (curso.isEmpty())
            System.out.println("Esta vacio");
        else if (curso.isBlank())
            System.out.println("Está vacío pero con espacios en blanco.");
    }
}
