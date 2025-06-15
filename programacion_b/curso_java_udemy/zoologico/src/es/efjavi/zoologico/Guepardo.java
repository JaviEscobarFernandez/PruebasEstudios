package es.efjavi.zoologico;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El guepardo acecha a su presa sigilosa y velozmente";
    }

    @Override
    public String dormir() {
        return "El guepardo se acuesta en un árbol a dormir plácidamente";
    }

    @Override
    public String correr() {
        return "¿Que ha sido eso? oh si es el guepardo corriendo";
    }

    @Override
    public String comunicarse() {
        return "El guepardo emite un gañido";
    }
}
