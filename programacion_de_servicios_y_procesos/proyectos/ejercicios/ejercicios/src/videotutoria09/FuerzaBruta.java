package videotutoria09;

import java.util.ArrayList;

public class FuerzaBruta {
    private static final char primerCaracter = 'a';
    private static final char ultimoCaracter = 'z';

    private static ArrayList<String> generarCombinaciones4() {
        ArrayList<String> combinaciones = new ArrayList<>();

        // recorremos todos los caracteres de la 'a' a la 'z' en cuatro iteraciones para obtener
        // todas las combinaciones de caracteres para almacenarlas en una lista
        for (char i = primerCaracter; i <= ultimoCaracter; i++) {
            for (char j = primerCaracter; j <= ultimoCaracter; j++) {
                for (char k = primerCaracter; k <= ultimoCaracter; k++) {
                    for (char l = primerCaracter; l <= ultimoCaracter; l++) {
                        StringBuilder cadena = new StringBuilder();
                        cadena.append(i).append(j).append(k).append(l);
                        combinaciones.add(cadena.toString());
                    }
                }
            }
        }

        return combinaciones;
    }

    public static void reventarPass(String password) {
        ArrayList<String> combinaciones = generarCombinaciones4();
        System.out.println("Mostramos las combinaciones generadas: " + combinaciones.size());
        System.out.println(combinaciones);
        String resultado = "***Sin coincidencias***";
        // iteramos las combinaciones y comparamos con la contraseña, si la encuentra finaliza el bucle
        for (int i = 0; i < combinaciones.size(); i++) {
            if (combinaciones.get(i).equals(password)) {
                resultado = combinaciones.get(i);
                break;
            }
        }
        System.out.println("La contraseña es: " + resultado);
    }

    private static ArrayList<String> generarCombinaciones6() {
        ArrayList<String> combinaciones = new ArrayList<>();

        // recorremos todos los caracteres de la 'a' a la 'z' en cuatro iteraciones para obtener
        // todas las combinaciones de caracteres para almacenarlas en una lista
        for (char i = primerCaracter; i <= ultimoCaracter; i++) {
            for (char j = primerCaracter; j <= ultimoCaracter; j++) {
                for (char k = primerCaracter; k <= ultimoCaracter; k++) {
                    for (char l = primerCaracter; l <= ultimoCaracter; l++) {
                        for (char m = primerCaracter; m <= ultimoCaracter; m++) {
                            for (char n = primerCaracter; n <= ultimoCaracter; n++) {
                                StringBuilder cadena = new StringBuilder();
                                cadena.append(i).append(j).append(k).append(l).append(m).append(n);
                                combinaciones.add(cadena.toString());
                            }
                        }
                    }
                }
            }
        }

        return combinaciones;
    }

    public static void reventarPassHard(String password) {
        // no podemos realizarlo en un arraylist porque sobrepasa la memoria maxima
        // ArrayList<String> combinaciones = generarCombinaciones6();
        String resultado = "***Sin coincidencias***";
        // iteramos las combinaciones y comparamos con la contraseña, si la encuentra finaliza el bucle
        // recorremos todos los caracteres de la 'a' a la 'z' en cuatro iteraciones para obtener todas las combinaciones
        for (char i = primerCaracter; i <= ultimoCaracter; i++) {
            for (char j = primerCaracter; j <= ultimoCaracter; j++) {
                for (char k = primerCaracter; k <= ultimoCaracter; k++) {
                    for (char l = primerCaracter; l <= ultimoCaracter; l++) {
                        for (char m = primerCaracter; m <= ultimoCaracter; m++) {
                            for (char n = primerCaracter; n <= ultimoCaracter; n++) {
                                StringBuilder cadena = new StringBuilder();
                                cadena.append(i).append(j).append(k).append(l).append(m).append(n);
                                if (cadena.toString().equals(password)) {
                                    resultado = cadena.toString();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("La contraseña es: " + resultado);
    }
}
