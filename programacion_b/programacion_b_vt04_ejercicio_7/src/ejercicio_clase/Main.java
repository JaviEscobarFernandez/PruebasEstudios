package ejercicio_clase;

/*
 * Ejercicio 4 (Ejercicio inicial):
 * Crea una clase base en Java que se llame Animal:
 * Como atirbutos nombre, color (Strings) y edad (int).
 * Como métodos, comer (mostrará "Comiendo..."), dormir (mostrará "ZzZZzzZ")
 * y emitirSonido (mostrará "Sonido!")
 * 
 * Heredan de ella dos clases derivadas, Perro y Gato
 * Perro tendrá un atributo más, raza (String) pero no es obligatorio para instanciar un objeto.
 * Perro tendrá un método get para el atributo raza.
 * Perro sobrescribira emitirSonido para mostrar "Guau!".
 * 
 * Gato sobrescribira emitirSonido para mostrar "Miau!".
 * Gato tambien sobrescribe comer para mostrar "Comiendo pescado".
 * 
 * En el metodo main, instancia al menos un objeto de cada clase derivada,
 * haciendo que coman, duerman y emitan un sonido.
 * 
 * Añadido del Ejercicio 7:
 * Divide la clase Animal en una clase abstracta que tenga tres parametos
 * y un metodo dormir (que sera comun para todas las clases base)
 * y en una interfaz que tenga dos metodos, comer y emitirSonido.
 */

public class Main {

    public static void main(String[] args) {
        Perro toby = new Perro("Toby", "Blanco", 4);
        toby.comer();
        toby.dormir();
        toby.emitirSonido();

        Gato simba = new Gato("Simba", "Negro", 10);
        simba.comer();
        simba.dormir();
        simba.emitirSonido();
    }

}
