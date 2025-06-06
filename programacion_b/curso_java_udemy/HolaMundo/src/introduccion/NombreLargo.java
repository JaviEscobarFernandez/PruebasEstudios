package introduccion;

import javax.swing.*;

public class NombreLargo {
    public static void main(String[] args) {
        String[] nombres = new String[3];
        int maxLength = 0;
        int topPos = 0;
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog("Introduce el nombre de la persona número: " + (i + 1));
            if (nombres[i].length() > maxLength) {
                maxLength = nombres[i].length();
                topPos = i;
            }
        }
        System.out.println(nombres[topPos] + " es el de mayor longitud.");
    }
}
