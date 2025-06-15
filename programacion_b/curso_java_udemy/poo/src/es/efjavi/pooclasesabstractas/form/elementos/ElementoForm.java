package es.efjavi.pooclasesabstractas.form.elementos;

import es.efjavi.pooclasesabstractas.form.validador.LargoValidador;
import es.efjavi.pooclasesabstractas.form.validador.Validador;
import es.efjavi.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {
    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        validadores = new ArrayList<>();
        errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) { this.valor = valor; }
    public String getNombre() { return nombre; }
    public List<String> getErrores() { return errores; }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public boolean esValido() {
        for (Validador v : validadores) {
            if (!v.esValido(valor)) {
                if (v instanceof MensajeFormateable)
                    errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre));
                else
                    errores.add(String.format(v.getMensaje(), nombre));
            }
        }
        return errores.isEmpty();
    }

    public abstract String dibujarHtml();
}
