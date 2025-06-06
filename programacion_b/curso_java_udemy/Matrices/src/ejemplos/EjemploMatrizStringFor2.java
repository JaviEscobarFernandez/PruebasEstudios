package ejemplos;

public class EjemploMatrizStringFor2 {
    public static void main(String[] args) {
        String[][] nombres = { {"Pepe", "Pepa"}, {"Josefa", "Paco"}, {"Lucas", "Pancha"} };

        for (String[] fila : nombres) {
            for (String col : fila) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
