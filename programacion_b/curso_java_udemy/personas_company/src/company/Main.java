package company;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Pedro", "Piqueras", "12345678-A", "Avenida falsa 1234", 1200.34, 50000);
        gerente.setPresupuesto(60000);
        gerente.aumentarRemuneracion(25);
        System.out.println(gerente);
    }
}
