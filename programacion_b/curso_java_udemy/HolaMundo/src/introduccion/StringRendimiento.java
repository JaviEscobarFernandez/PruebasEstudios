package introduccion;

public class StringRendimiento {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;

        long inicio = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder(c);
        for (int i = 0; i < 1000; i++) {
            // c = c.concat(a).concat(b).concat("\n"); // 4-5 ms
            // c += a + b + "\n"; // 17-18 ms
            sb.append(a).append(b).append("\n"); // 0 ms !!!

        }

        System.gc();

        long fin = System.currentTimeMillis();
        System.out.println("Diff = " + (fin - inicio));
        System.out.println(c);
        System.out.println(sb.toString());

        System.exit(0);
    }
}
