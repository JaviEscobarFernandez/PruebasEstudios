package ejemplos;

public class OrdenamientoBurbuja {
    public static void main(String[] args) {
        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";

        ordenarBuburja(productos);
        for (String s : productos) {
            System.out.println("s = " + s);
        }

        Integer[] numeros = { 1, 49, -1, 45, -4, 0, 12 };
        ordenarBuburja(numeros);
        for (int i : numeros) {
            System.out.println("i = " + i);
        }
    }

    private static void ordenarBuburja(Object[] array) {
        int total = array.length;
        int contador = 0;
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < (total - 1 - i); j++) {
                if (((Comparable)array[j + 1]).compareTo(array[j]) < 0) {
                    Object aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);
    }
}
