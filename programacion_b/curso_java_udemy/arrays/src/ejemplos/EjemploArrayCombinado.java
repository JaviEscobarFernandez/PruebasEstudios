package ejemplos;

public class EjemploArrayCombinado {
    public static void main(String[] args) {
        int[] a, b, c;
        a = new int[12];
        b = new int[12];
        c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            b[i] = a[i] * 5;
        }

        int aux = 0;
        for (int i = 0; i < b.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                c[aux++] = a[i + j];
            }
            for (int j = 0; j < 3; j++) {
                c[aux++] = b[i + j];
            }
        }

        for (int i : c) {
            System.out.println("i = " + i);
        }
    }
}
