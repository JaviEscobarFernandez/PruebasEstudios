package es.efjavi.practica.ejercicio4;

public class Moto extends Vehiculo implements Conducible {
    private int cilindrada;

    public Moto(String marca, int cilindrada) {
        super(marca);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() { return cilindrada; }

    @Override
    public void conducir() {
        System.out.println("La moto de marca: " + getMarca() + " esta siendo conducida.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Moto marca: " + getMarca() + " de cilindrada: " + cilindrada);
    }
}
