package introduccion;

public class BucleEtiquetaBuscar {
    public static void main(String[] args) {
        String frase = "tres tristes tigres tragan trigo en un trigal. trigo trigo trigo";
        String palabra = "trigo";

        int count = 0;
        buscar:for (int i = 0; i < frase.length(); i++) {
            int k = i;
            for (int j = 0; j < palabra.length(); j++) {
                if (frase.charAt(k++) != palabra.charAt(j))
                    continue buscar;
            }
            count++;
        }
        System.out.println("Encontrado " + count + " veces la palabra: " + palabra + " en la frase: " + frase);
    }
}
