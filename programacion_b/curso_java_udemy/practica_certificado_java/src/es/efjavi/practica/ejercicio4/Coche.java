package es.efjavi.practica.ejercicio4;

public class Coche extends Vehiculo implements Conducible {
    private int puertas;

    public Coche(String marca, int puertas) {
        super(marca);
        this.puertas = puertas;
    }

    public int getPuertas() { return puertas; }

    @Override
    public void conducir() {
        System.out.println("El coche de marca: " + getMarca() + " esta siendo conducido.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Coche marca: " + getMarca() + " número de puertas: " + puertas);
    }
}
