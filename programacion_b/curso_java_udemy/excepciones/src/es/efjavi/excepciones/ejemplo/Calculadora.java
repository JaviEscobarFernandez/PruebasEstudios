package es.efjavi.excepciones.ejemplo;

public class Calculadora {
    public double dividir(int num, int divisor) throws DivisionPorZeroException {
        if (divisor == 0)
            throw new DivisionPorZeroException("ERROR: No es posible dividir entre 0");
        return num / (double)divisor;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorZeroException, FormatoNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return dividir(num, div);
        } catch (NumberFormatException e) {
            throw new FormatoNumeroException("ERROR: valor introducido no válido, debes introducir valores numéricos enteros.");
        }
    }
}
