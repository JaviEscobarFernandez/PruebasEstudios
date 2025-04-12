package codigo;

import java.util.Random;

/*
 * Consistirá en la programación de las siguientes clases e interfaces en Java:
 * a. Una superclase Personaje que consistirá en:
 *      o Atributos privados:
 *          1. nombre (String). Nombre del objeto instanciado.
 *          2. salud (int). Salud actual del objeto instanciado..
 *          3. nivel (int). Nivel de experiencia del objeto instanciado.
 *      o Métodos:
 *          1. Constructor público para inicializar todos los atributos (edad es opcional, tendrás que usar la sobrecarga de métodos)
 *          2. Getters y Setters públicos de todos los atributos
 * b. Una interfaz Guerrero que obligue a la implementación de los métodos:
 *      o atacar(Personaje). Para atacar a un objeto de la clase Personaje.
 *      o defender(Personaje). Para defenderse del ataque de un Personaje.
 * c. Una subclase PJugador que herede de Personaje e implemente Guerrero, y que consistirá en:
 *      o Atributos privados adicionales:
 *          1. edad (int). Edad del objeto instanciado (del PJugador)
 *          2. ataque (int). Cuantía de daño que provoca el ataque.
 *          3. defensa (int). Nivel de daño que absorbe la armadura ante un ataque.
 *      o Métodos:
 *          1. Constructor público para inicializar todos los atributos. Usa la
 *              sobrecarga de métodos para que edad sea opcional. No olvides la llamada al superconstructor.
 *          2. Getters y Setters públicos para los atributos que no lo tengan heredado.
 *          3. atacar(Personaje): Envía un ataque a un Personaje equivalente a multiplicar el nivel del PJugador que ataca por su atributo ataque.
 *              Si esta cantidad es superior a la salud del Personaje atacado, morirá (su salud será 0).
 *              Si no, a la salud de este Personaje se le restarán los puntos del ataque = atributo ataque del PJugador que ataca multiplicado por su nivel.
 *          4. defender(Personaje): Resta el daño de un ataque de un Personaje (que equivale a su nivel) menos el atributo defensa.
 *              Cuando un Personaje lance un ataque a un PJugador, lo hará con una cantidad de daño igual a su nivel.
 *              Esa cantidad se verá contrarrestada por el atributo de defensa del PJugador que se defiende del ataque.
 *              Si el daño no es superior a la defensa, el PJugador no recibirá daño. Si el daño es superior, recibirá un daño igual
 *              a la resta del parámetro enviado menos el atributo de defensa.
 *              Si el daño resultante es superior a la salud del PJugador, este muere.
 */

public class Rol {

    public static void main(String[] args) {
        // Creacion de jugadores
        PJugador jugador1 = new PJugador("Aragorn", dado(3,100), dado(2,12), dado(1,6), dado(1,4));
        PJugador jugador2 = new PJugador("Legolas", dado(3,100), dado(2,12), dado(1,6), dado(1,4));
        PJugador jugador3 = new PJugador("Gimli", dado(3,100), dado(2,12), dado(1,6), dado(1,4));

        // Creacion de enemigos
        Personaje enemigo1 = new Personaje("Orco", dado(2,100), dado(1,12));
        Personaje enemigo2 = new Personaje("Urukhai", dado(2,100), dado(1,12));
        Personaje enemigo3 = new Personaje("Troll", dado(2,100), dado(1,12));

        // Inicio de la batalla
        System.out.println(jugador1.getNombre() + ", " + jugador2.getNombre() + " y " + jugador3.getNombre() + " son emboscados por un grupo de enemigos");
        System.out.println("¡Comienza la batalla!\n");
        pjAtaca(jugador1,enemigo3);
        pjAtaca(jugador2,enemigo2);
        pjAtaca(jugador3,enemigo1);
        pnjAtaca(enemigo3,jugador1);
        pnjAtaca(enemigo2,jugador2);
        pnjAtaca(enemigo1,jugador3);
        pjAtaca(jugador2,enemigo3);
        pjAtaca(jugador3,enemigo2);
        pjAtaca(jugador1,enemigo1);
        pnjAtaca(enemigo3,jugador2);
        pnjAtaca(enemigo2,jugador3);
        pnjAtaca(enemigo1,jugador1);
    }

    // Metodo para generar un valor aleatorio (simular un dado de rol)
    private static int dado(int d, int c) {
        Random r = new Random();
        int res = 0;
        for (int i = 0; i < d; i++)
            res += r.nextInt(c) + 1;
        return res;
    }

    // Metodo estatico para realizar el ataque de un jugador a un enemigo
    private static void pjAtaca(PJugador pj, Personaje enemigo) {
        if (!ataqueValido(pj, enemigo))
            return;

        pj.atacar(enemigo); // El jugador ataca al enemigo
        System.out.println();
    }

    // Metodo estatico para realizar el ataque de un enemigo a un jugador
    private static void pnjAtaca(Personaje pnj, PJugador jugador) {
        if (!ataqueValido(pnj, jugador))
            return;

        jugador.defender(pnj); // El jugador se defiende del ataque del enemigo
        System.out.println();
    }

    // Metodo para comprobar si es posible realizar el ataque o no
    private static boolean ataqueValido(Personaje atacante, Personaje objetivo) {
        if (atacante.estaMuerto()) // El atacante esta muerto, no es posible que ataque, no mostramos mensaje tampoco.
            return false;

        if (objetivo.estaMuerto()) {
            System.out.println(atacante.getNombre() + " no puede realizar un ataque a " + objetivo.getNombre() + " porque ya está muerto");
            return false;
        }

        return true; // Todo en orden, es valido
    }
}
