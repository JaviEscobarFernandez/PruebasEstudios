package introduccion;

public class EjemploString {
    public static void main(String[] args) {
        String curso = "Programación Java";
        String curso2 = new String("Programación Java");
        System.out.println("curso es igual a curso2? " + (curso == curso2));
        System.out.println("curso es igual a curso2 con equals? " + curso.equals(curso2));

        String curso3 = "Programación Java";
        System.out.println("curso es igual a curso3? " + (curso == curso3));

        String profesor = "Andrés Guzmán";
        String detalle = curso + " con el profesor: " + profesor;
        System.out.println(detalle);

        int a = 10;
        int b = 5;
        System.out.println(detalle + a + b);
        System.out.println(detalle + (a + b));
        System.out.println(a + b + detalle);

        String detalle2 = curso.concat(" con el profesor: " + profesor);
        System.out.println(detalle2);

        // prueba de inmutabilidad
        String resultado = curso.concat(profesor);
        System.out.println("curso: " + curso);
        System.out.println("resultado: " + resultado);

        // prueba lamda
        String resultado2 = curso.transform(c -> {
            return c + " con " + profesor;
        });
        System.out.println("curso: " + curso);
        System.out.println("resultado2: " + resultado2);

        String resultado3 = resultado2.replace("a", "A");
        System.out.println("resultado2: " + resultado2);
        System.out.println("resultado3: " + resultado3);


    }
}
