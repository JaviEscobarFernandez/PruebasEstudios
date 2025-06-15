package es.efjavi.zoologico;

public class Lobo extends Canino {
    private int numCamada;
    private String especieLobo;

    public Lobo(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
    }

    public int getNumCamada() { return numCamada; }
    public String getEspecieLobo() { return especieLobo; }

    @Override
    public String comer() {
        return "El lobo con sus colmillos de " + getTamanoColmillos() + "cm puede hacer estragos";
    }

    @Override
    public String dormir() {
        return "El Lobo " + getColor() + " duerme en las cavernas de " + getHabitat();
    }

    @Override
    public String correr() {
        return "El lobo " + getEspecieLobo() + " corre solo cuando lo necesita.";
    }

    @Override
    public String comunicarse() {
        return "El lobo se comunica con " + getNumCamada() + " lobos de su camada";
    }

    @Override
    public String toString() {
        return super.toString() + "\nnumCamada: " + numCamada +
                ", especieLobo: '" + especieLobo + '\'';
    }
}
