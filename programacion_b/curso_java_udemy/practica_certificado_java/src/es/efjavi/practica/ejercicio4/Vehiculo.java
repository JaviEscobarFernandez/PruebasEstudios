package es.efjavi.practica.ejercicio4;

public abstract class Vehiculo {
    protected String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public String getMarca() { return marca; }

    public abstract void mostrarInfo();
}
