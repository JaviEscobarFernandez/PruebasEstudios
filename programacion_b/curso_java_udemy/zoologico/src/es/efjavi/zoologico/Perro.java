package es.efjavi.zoologico;

public class Perro extends Canino {
    private int fuerzaMordida;

    public Perro(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() { return fuerzaMordida; }

    @Override
    public String comer() {
        return "El perro desentierra un hueso y se pone a comer, menuda fuerza tiene: " + getFuerzaMordida();
    }

    @Override
    public String dormir() {
        return "El perro se tumba panza arriba y empieza a roncar";
    }

    @Override
    public String correr() {
        return "El perro corre a por el conejo";
    }

    @Override
    public String comunicarse() {
        return "El perro ladra contento";
    }

    @Override
    public String toString() {
        return super.toString() + "\nfuerzaMordida: " + fuerzaMordida;
    }
}
