package es.efjavi.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador {
    protected String mensaje = "el campo %s tiene un formato del correo inválido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";
    @Override
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String getMensaje() { return mensaje; }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_REGEX);
    }
}
