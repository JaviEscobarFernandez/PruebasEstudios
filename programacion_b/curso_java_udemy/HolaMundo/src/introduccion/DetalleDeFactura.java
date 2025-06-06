package introduccion;

import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduce el nombre de la factura: ");
            String nombreFactura = sc.nextLine();
            System.out.print("Introduce el precio del primer producto: ");
            double a = sc.nextDouble();
            sc.nextLine();
            System.out.print("Introduce el precio del segundo producto: ");
            double b = sc.nextDouble();
            double totalBruto = a + b;
            double impuesto = totalBruto * 19 / 100;
            double totalNeto = totalBruto + impuesto;
            System.out.println("La factura " + nombreFactura + " tiene un total bruto de " + totalBruto +
                    ", con un impuesto de " +  impuesto + " y el monto después de impuesto es de " + totalNeto);
        } catch(Exception e) {
            System.err.println("Error dato introducido no válido.");
        } finally {
            sc.close();
        }
    }
}
