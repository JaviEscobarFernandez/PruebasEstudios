package es.efjavi.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible {
    private Persona autor;
    private Persona revisor;

    public Informe(Persona autor, Persona revisor, String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Informe escrito por: ").append(autor)
                .append(" Revisado por: ").append(revisor)
                .append("\n").append(contenido);
        return sb.toString();
    }
}
