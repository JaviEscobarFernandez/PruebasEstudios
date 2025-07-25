package es.efjavi.pooclasesabstractas.form.elementos;

import es.efjavi.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm {
    private List<Opcion> opciones;

    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<>();
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    public SelectForm addOpcion(Opcion opcion) {
        opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<select ");
        sb.append("name='").append(nombre).append("'>");
        for (Opcion o : opciones) {
            sb.append("\n<option value='").append(o.getValor()).append("'");
            if (o.isSelected()) {
                sb.append(" selected");
                this.valor = o.getValor();
            }
            sb.append(">").append(o.getNombre()).append("</option>");
        }
        sb.append("\n</select>");
        return sb.toString();
    }
}
