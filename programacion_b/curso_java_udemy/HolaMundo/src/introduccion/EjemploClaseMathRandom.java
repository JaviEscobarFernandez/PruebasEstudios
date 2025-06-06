package introduccion;

import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {
        String[] colores = { "azul", "amarillo", "rojo", "verde", "blanco", "negro" };
        double random = Math.random();
        System.out.println("random = " + random);
        random *= colores.length;
        System.out.println("random = " + random);
        
        random = Math.floor(random);
        System.out.println("random = " + random);

        System.out.println("colores = " + colores[(int)random]);
        
        double max = 0;
        for (int i = 0; i < 1000; i++) {
            max = Math.max(max, Math.random() * 100);
        }
        System.out.println("max = " + max);

        Random rand = new Random();
        int randomInt = 15 + rand.nextInt(25 - 15 + 1);
        System.out.println("randomInt = " + randomInt);
        
        randomInt = rand.nextInt(colores.length);
        System.out.println("randomInt = " + randomInt);
        System.out.println("colores = " + colores[randomInt]);
    }
}
