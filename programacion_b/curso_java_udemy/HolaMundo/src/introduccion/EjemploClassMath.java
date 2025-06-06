package introduccion;

public class EjemploClassMath {
    public static void main(String[] args) {
        int absoluto = Math.abs(-3);
        System.out.println("absoluto = " + absoluto);

        absoluto = Math.abs(3);
        System.out.println("absoluto = " + absoluto);
        
        double max = Math.max(3.5, 1.2);
        System.out.println("max = " + max);
        
        double min = Math.min(3.5, 1.2);
        System.out.println("min = " + min);
        
        double techo = Math.ceil(3.5);
        System.out.println("techo = " + techo);
        
        double suelo = Math.floor(3.5);
        System.out.println("suelo = " + suelo);
        
        long redondeo = Math.round(Math.PI);
        System.out.println("redondeo = " + redondeo);

        double exponente = Math.exp(2);
        System.out.println("exponente = " + exponente);

        double logaritmo = Math.log(10);
        System.out.println("logaritmo = " + logaritmo);
        
        double potencia = Math.pow(10, 4);
        System.out.println("potencia = " + potencia);
        
        double raiz = Math.sqrt(45);
        System.out.println("raiz = " + raiz);

        double grados = Math.toDegrees(1.57);
        grados = Math.round(grados);
        System.out.println("Convertir radianes a grados: " + grados);

        double radianes = Math.toRadians(90.00);
        System.out.println("Convertir grados a radianes: " + radianes);

        System.out.println("sin(90): " + Math.sin(radianes));
        System.out.println("cos(90): " + Math.cos(radianes));

        radianes = Math.toRadians(180.00);
        System.out.println("sin(180): " + Math.sin(radianes));
        System.out.println("cos(180): " + Math.cos(radianes));
    }
}
