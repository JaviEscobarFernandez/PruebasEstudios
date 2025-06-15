package es.efjavi.zoologico;

public abstract class Canino extends Mamifero {
    protected String color;
    protected float tamanoColmillos;

    public Canino(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    public String getColor() { return color; }
    public float getTamanoColmillos() { return tamanoColmillos; }

    @Override
    public String toString() {
        return super.toString() + "\ncolor: '" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos;
    }
}
