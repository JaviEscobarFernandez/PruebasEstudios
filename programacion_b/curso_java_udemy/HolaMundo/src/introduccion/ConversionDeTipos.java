package introduccion;

public class ConversionDeTipos {
    public static void main(String[] args) {
        String numeroStr = "50";
        int numeroInt = Integer.parseInt(numeroStr);
        System.out.println("numeroInt = " + numeroInt);

        String realStr = "213114.76";
        double realDouble = Double.parseDouble(realStr);
        System.out.println("realDouble = " + realDouble);

        String logicoStr = "tRuE";
        boolean logicoBool = Boolean.parseBoolean(logicoStr);
        System.out.println("logicoBool = " + logicoBool);

        int otroNumeroInt = 100;
        System.out.println("otroNumeroInt = " + otroNumeroInt);
        String otroNumeroStr = Integer.toString(otroNumeroInt);
        System.out.println("otroNumeroStr = " + otroNumeroStr);
        otroNumeroStr = String.valueOf(otroNumeroInt + 10);
        System.out.println("otroNumeroStr = " + otroNumeroStr);

        double otroRealDouble = 132124.1234;
        String otroRealStr = Double.toString(otroRealDouble);
        System.out.println("otroRealStr = " + otroRealStr);
        otroRealStr = String.valueOf(otroRealDouble * 2);
        System.out.println("otroRealStr = " + otroRealStr);

        int i = 1000;
        short s = (short)i;
        long l = (long)s;
        System.out.println("i = " + i + " s = " + s + " l = " + l);
    }
}
