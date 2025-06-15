package es.efjavi.zoologico;

public class Tigre extends Felino {
    private String especieTigre;

    public Tigre(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() { return especieTigre; }

    @Override
    public String comer() {
        return "El tigre se abalanza sobre su presa y la devora febrilmente";
    }

    @Override
    public String dormir() {
        return "El tigre se echa a dormir sus 16 horitas diarias";
    }

    @Override
    public String correr() {
        return "El tigre hace el intento de correr, pero se lo piensa mejor y se tumba.";
    }

    @Override
    public String comunicarse() {
        return "El tigre " + getEspecieTigre() + " empieza a rugir";
    }

    @Override
    public String toString() {
        return super.toString() + "\nespecieTigre: '" + especieTigre + '\'';
    }
}
