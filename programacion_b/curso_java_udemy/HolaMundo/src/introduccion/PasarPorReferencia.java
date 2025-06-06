package introduccion;

class Persona {
    private int edad;
    private String nombre;

    Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() { return edad; }
    public String getNombre() { return nombre; }
    public void setEdad(int e) { edad = e; }
    public void setNombre(String n) { nombre = n; }
}

public class PasarPorReferencia {
    public static void main(String[] args) {
        int[] edad = { 10, 11, 12 };

        System.out.println("iniciar el método main con");
        for (int e : edad) {
            System.out.println("edad = " + e);
        }
        Persona persona = new Persona(30, "Pepe");
        System.out.println("nombre: " + persona.getNombre() + " edad " + persona.getEdad());
        System.out.println("Antes de llamar al método test");
        test(edad, persona);
        System.out.println("Finaliza el método main despues de llamar al método test con");
        for (int e : edad) {
            System.out.println("edad = " + e);
        }
        System.out.println("nombre: " + persona.getNombre() + " edad " + persona.getEdad());
    }

    private static void test(int[] edadArray, Persona persona) {
        System.out.println("Iniciamos el método test con");
        for (int i = 0; i < edadArray.length; i++) {
            System.out.println("edad = " + edadArray[i]);
            edadArray[i] += 20;
        }
        persona.setNombre("Juan");
        System.out.println("Finaliza el método test con");
        for (int e : edadArray) {
            System.out.println("edad = " + e);
        }
    }
}
