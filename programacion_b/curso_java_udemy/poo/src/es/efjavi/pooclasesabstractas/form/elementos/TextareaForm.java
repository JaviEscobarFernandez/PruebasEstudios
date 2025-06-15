package es.efjavi.pooclasesabstractas.form.elementos;

public class TextareaForm extends ElementoForm {
    private int filas;
    private int columnas;

    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public void setFilas(int filas) { this.filas = filas; }
    public void setColumnas(int columnas) { this.columnas = columnas; }

    @Override
    public String dibujarHtml() {
        return "<textarea name='" + nombre + "' cols='" + columnas +
                "' rows='" + filas + "'>" + valor + "</textarea>";
    }
}
