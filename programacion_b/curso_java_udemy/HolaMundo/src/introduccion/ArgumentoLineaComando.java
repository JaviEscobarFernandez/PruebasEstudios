package introduccion;

public class ArgumentoLineaComando {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumentos nº " + i + ": " + args[i]);
        }

        if (args.length != 3) {
            System.err.println("Por favor, es necesario introducir una operación (suma, resta, div o multi) y dos enteros");
            System.exit(1);
        }
        String operacion = args[0];
        int a = 0;
        int b = 0;
        double resultado = 0.0;
        try {
            a = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.err.println("ERROR: parametros introducidos no válidos.");
            System.exit(1);
        }

        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = a + b;
                break;
            case "resta":
                resultado = a - b;
                break;
            case "multi":
                resultado = a * b;
                break;
            case "div":
                if (b == 0) {
                    System.err.println("ERROR: no es posible dividir entre 0");
                    System.exit(1);
                }
                resultado = a / b;
                break;
            default:
                resultado = a + b;
        }
        System.out.println("Resultado de la operación " + operacion + ": " + resultado);
    }
}
