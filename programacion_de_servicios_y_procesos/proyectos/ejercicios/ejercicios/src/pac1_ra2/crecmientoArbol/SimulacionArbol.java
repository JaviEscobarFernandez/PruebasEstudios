package pac1_ra2.crecmientoArbol;

public class SimulacionArbol {
    static void main(String[] args) {

        System.out.println("Comienza la simulación del crecimiento del árbol.");

        // Creamos las ramas principales del árbol
        RamaArbol ramaPrincipal1 = new RamaArbol("Rama Principal 1", 10);
        RamaArbol ramaPrincipal2 = new RamaArbol("Rama Principal 2", 8);
        RamaArbol ramaSecundaria1 = new RamaArbol("Rama Secundaria A", 12);

        // Iniciamos el crecimiento de las ramas (cada una en su propio hilo)
        ramaPrincipal1.start();
        ramaPrincipal2.start();
        ramaSecundaria1.start();

        System.out.println("Las ramas principales están creciendo de forma concurrente...");

        // Esperamos a que las ramas principales terminen de crecer (opcional, para ver el final)
        try {
            ramaPrincipal1.join();
            ramaPrincipal2.join();
            ramaSecundaria1.join();
        } catch (InterruptedException e) {
            System.out.println("La simulación principal fue interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Fin de la simulación del crecimiento del árbol.");
    }
}
