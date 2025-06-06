package introduccion;

import java.util.Scanner;

public class EstanqueGasolina {
    public static void main(String[] args) {
        int MAX_CAP = 70;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Por favor, introduce la capacidad actual del estanque en litros: ");
            int c = sc.nextInt();
            String mensaje = "";
            if (c >= MAX_CAP)
                mensaje = "Estanque lleno";
            else if (c < MAX_CAP && c >= 60)
                mensaje = "Estanque casi lleno";
            else if (c < 60 && c >= 40)
                mensaje = "Estanque 3/4";
            else if (c < 40 && c >= 35)
                mensaje = "Estanque a la mitad";
            else if (c < 35 && c >= 20)
                mensaje = "Suficiente";
            else if (c >= 1)
                mensaje = "Insuficiente";
            System.out.println(mensaje);
        } catch(Exception e) {
            System.err.println("ERROR: Dato no válido.");
        } finally {
            sc.close();
        }
    }
}
