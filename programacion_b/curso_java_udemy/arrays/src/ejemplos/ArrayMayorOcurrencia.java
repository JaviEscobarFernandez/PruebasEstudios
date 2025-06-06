package ejemplos;

public class ArrayMayorOcurrencia {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 7 };
        int totalOcurrencias = 0;
        int numMaxOcurrencias = 0;

        for (int i = 0; i < numeros.length; i++) {
            int numAux = i;
            int contAux = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numAux == numeros[j])
                    contAux++;
            }
            if (contAux > totalOcurrencias) {
                totalOcurrencias = contAux;
                numMaxOcurrencias = numAux;
            }
        }

        System.out.println("La mayor ocurrencia es de: " + totalOcurrencias);
        System.out.println("El elemento que más se repite es: " + numMaxOcurrencias);
    }
}
