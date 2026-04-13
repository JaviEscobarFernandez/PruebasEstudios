package servidor;

import java.util.*;

// Esta clase hacemos todos sus metodos static, ya que no es necesario instanciarla para su funcionalidad
public class ServicioPass {

    private static final Random rand = new Random();

    // metodo para obtener la longitud de la pass
    public static int getPassLength(RequisitosPass requisitos) {
        int suma = 0;
        suma += requisitos.getNumCaractEspeciales();
        suma += requisitos.getNumDigitos();
        suma += requisitos.getNumMayusculas();
        suma += requisitos.getNumMinusculas();
        return suma;
    }

    // metodo para generar la pass de forma aleatoria en base a los requisitos proporcionados
    public static String generateRandomPass(RequisitosPass requisitos) {
        StringBuilder randomCaracteres = new StringBuilder();

        // generamos N caracteres de mayusculas aleatorios
        for (int i = 0; i < requisitos.getNumMayusculas(); i++) {
            randomCaracteres.append(getRandomMayus());
        }

        // generamos N caracteres de minusculas aleatorios
        for (int i = 0; i < requisitos.getNumMinusculas(); i++) {
            randomCaracteres.append(getRandomMinus());
        }

        // generamos N digitos aleatorios
        for (int i = 0; i < requisitos.getNumDigitos(); i++) {
            randomCaracteres.append(getRandomDigit());
        }

        // generamos N caracteres especiales aleatorios
        for (int i = 0; i < requisitos.getNumCaractEspeciales(); i++) {
            randomCaracteres.append(getRandomCharacter());
        }
        String pass = String.valueOf(randomCaracteres);
        return shufflePass(pass);
    }

    private static String getRandomMayus() {
        // generamos un caracter aleatorio de la A a la Z (26 caracteres de diferencia)
        char c = (char) ('A' + rand.nextInt(26));
        return String.valueOf(c);
    }

    private static String getRandomMinus() {
        // generamos un caracter aleatorio de la a a la z (26 caracteres de diferencia)
        char c = (char) ('a' + rand.nextInt(26));
        return String.valueOf(c);
    }

    private static String getRandomDigit() {
        int num = rand.nextInt(10); // del 0 al 9
        return String.valueOf(num);
    }

    private static String getRandomCharacter() {
        String caracteresEspeciales = "!@#$%^&*()_-+=.:?";
        int caracter = rand.nextInt(caracteresEspeciales.length());
        char c = caracteresEspeciales.charAt(caracter);
        return String.valueOf(c);
    }

    private static String shufflePass(String pass) {
        // convertimos el string en una lista de caracteres
        List<Character> caracteres = new ArrayList<>();
        for (char c : pass.toCharArray()) {
            caracteres.add(c);
        }

        // usamos shuffle de Collections para mezclarlos aleatoriamente
        Collections.shuffle(caracteres);

        // reconstruimos el String
        StringBuilder passMezclado = new StringBuilder();
        for (char c : caracteres) {
            passMezclado.append(c);
        }

        return String.valueOf(passMezclado);
    }
}
