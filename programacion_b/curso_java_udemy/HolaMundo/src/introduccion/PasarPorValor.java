package introduccion;

public class PasarPorValor {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("iniciar el método main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con i (inalterado) = " + i);
    }

    private static void test(int i) {
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finaliza el método test con i = " + i);
    }
}
