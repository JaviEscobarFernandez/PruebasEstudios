package codigo;

public class PJugador extends Personaje implements Guerrero {
    // Atributos
    private int edad;
    private int ataque;
    private int defensa;

    // Constructores
    PJugador(String nombre, int salud, int nivel, int ataque, int defensa) {
        super(nombre, salud, nivel);
        this.ataque = ataque;
        this.defensa = defensa;
    }

    PJugador(String nombre, int salud, int nivel, int ataque, int defensa, int edad) {
        super(nombre, salud, nivel);
        this.ataque = ataque;
        this.defensa = defensa;
        this.edad = edad;
    }

    // Getters
    public int getEdad() { return edad; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    // Setters
    public void setEdad(int e) { edad = e; }
    public void setAtaque(int a) { ataque = a; }
    public void setDefensa(int d) { defensa = d; }

    // Metodos implementados
    @Override
    public void atacar(Personaje enemigo) {
        int golpe = getNivel() * getAtaque();
        System.out.println(getNombre() + " asesta un golpe de " + golpe + " puntos a " + enemigo.getNombre());

        int saludEnemigo = enemigo.getSalud();
        if (enemigo.getSalud() <= golpe) {
            enemigo.setSalud(0);
            System.out.println(enemigo.getNombre() + " ha muerto.");
            return;
        }

        enemigo.setSalud(saludEnemigo - golpe);
        System.out.println("La salud de " + enemigo.getNombre() + " queda en " + enemigo.getSalud() + " puntos tras recibir el golpe de " + getNombre());
    }

    @Override
    public void defender(Personaje enemigo) {
        if (estaMuerto()) {
            System.out.println(getNombre() + " no puede defenderse porque ya está muerto.");
            return;
        }

        int golpe = enemigo.getNivel();
        System.out.println(getNombre() + " se defiende del golpe de " + golpe + " puntos del enemigo " + enemigo.getNombre());

        if (getDefensa() >= golpe) {
            System.out.println(getNombre() + " para el golpe por completo, no recibe ningún daño.");
            return;
        }

        golpe -= getDefensa();
        System.out.println(getNombre() + " reduce el golpe a " + golpe + " puntos gracias a su defensa de " + getDefensa() + " puntos.");
        int salud = getSalud();
        if (salud <= golpe) {
            setSalud(0);
            System.out.println(getNombre() + " ha muerto.");
            return;
        }

        setSalud(salud - golpe);
        System.out.println("La salud de " + getNombre() + " queda en " + getSalud() + " puntos tras recibir el golpe de " + enemigo.getNombre());
    }
}
