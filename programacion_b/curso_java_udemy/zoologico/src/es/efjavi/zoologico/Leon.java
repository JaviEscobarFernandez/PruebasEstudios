package es.efjavi.zoologico;

public class Leon extends Felino {
    private int numManada;
    private float potenciaRugidoDecibel;

    public Leon(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public int getNumManada() { return numManada; }
    public float getPotenciaRugidoDecibel() { return potenciaRugidoDecibel; }

    @Override
    public String comer() {
        return "El León caza junto a su grupo de " + getNumManada() + " individuos en las llanuras africanas";
    }

    @Override
    public String dormir() {
        return "El léon se pone a dormir placidamente";
    }

    @Override
    public String correr() {
        return "No tiene muchas ganas, se ha puesto a bostezar";
    }

    @Override
    public String comunicarse() {
        return "El león ruge con fiereza, que potencia: " + getPotenciaRugidoDecibel();
    }

    @Override
    public String toString() {
        return super.toString() + "\nnumManada: " + numManada +
                ", potenciaRugidoDecibel: " + potenciaRugidoDecibel;
    }
}
