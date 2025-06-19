package es.efjavi.excepciones.ejemplo;

public class DivisionPorZeroException extends Exception {
    public DivisionPorZeroException(String mensaje) {
        super(mensaje);
    }
}
