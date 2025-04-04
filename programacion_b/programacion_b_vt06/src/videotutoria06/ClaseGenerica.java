package videotutoria06;

public class ClaseGenerica<U extends Number, I> {
    private U atributoNumerico;
    private I atributoCualquiera;

    public ClaseGenerica(U att1, I att2) {
        atributoNumerico = att1;
        atributoCualquiera = att2;
    }

    public U getAtributoNumerico() { return atributoNumerico; }
    public I getAtributoCualquiera() { return atributoCualquiera; }

    public void setAtributoNumerico(U att) { atributoNumerico = att; }
    public void setAtributoCualquiera(I att) { atributoCualquiera = att; }

    public void imprimirAtributos() {
        System.out.println("Los atributos son:\nNumérico: " + atributoNumerico + "\nCualquiera: " + atributoCualquiera);
    }

    // Probando metodo con generico
    public static <T extends Number> void sumar(T num1, T num2) {
        double d = num1.doubleValue() + num2.doubleValue();
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + d);
    }

    public static <T extends Number> void tablaMultiplicar(T att1, int tabla) {
        for (int i = 1; i <= tabla; i++) {
            System.out.println(att1 + " x " + i + " = " + (i * att1.intValue()));
        }
    }
}
