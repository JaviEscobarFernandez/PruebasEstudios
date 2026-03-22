package pac1_ra2.crecmientoArbol;

class RamaArbol extends Thread {
    private String nombreRama;
    private int longitudMaxima;
    private int crecimientoActual;

    public RamaArbol(String nombreRama, int longitudMaxima) {
        this.nombreRama = nombreRama;
        this.longitudMaxima = longitudMaxima;
        this.crecimientoActual = 0;
        System.out.println("Nace la " + nombreRama);
    }

    @Override
    public void run() {
        try {
            while (crecimientoActual < longitudMaxima) {
                crecimientoActual += 1; // Crece 1 cm a la vez
                System.out.println(nombreRama + " ha crecido a " + crecimientoActual + " cm.");

                // Simulamos el tiempo que tarda en crecer
                Thread.sleep(1000 + (long)(Math.random() * 1500)); // Pausa entre 1 y 2.5 segundos

                if (crecimientoActual == longitudMaxima / 2 && nombreRama.split("-").length < 3) { // Condición para crear sub-ramas (máximo 2 niveles de sub-ramas)
                    RamaArbol subRama = new RamaArbol(nombreRama + "-sub" + (int)(Math.random() * 10), longitudMaxima / 2);
                    subRama.start(); // La nueva sub-rama comienza a crecer
                }
            }
            System.out.println("La " + nombreRama + " ha alcanzado su longitud máxima de " + longitudMaxima + " cm y deja de crecer.");
        } catch (InterruptedException e) {
            System.out.println("La " + nombreRama + " fue interrumpida en su crecimiento.");
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }
}