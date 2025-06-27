package es.efjavi.vuelos;

import java.util.Date;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLlegada;
    private int cantidadPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechaLlegada, int cantidadPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getNombre() { return nombre; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public Date getFechaLlegada() { return fechaLlegada; }
    public int getCantidadPasajeros() { return cantidadPasajeros; }

    @Override
    public String toString() {
        return "Vuelo: " + nombre +
                ", Origen: " + origen +
                ", Destino: " + destino +
                ", Fecha de llegada: " + fechaLlegada +
                ", Número de Pasajeros: " + cantidadPasajeros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return cantidadPasajeros == vuelo.cantidadPasajeros && Objects.equals(nombre, vuelo.nombre) && Objects.equals(origen, vuelo.origen) && Objects.equals(destino, vuelo.destino) && Objects.equals(fechaLlegada, vuelo.fechaLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, origen, destino, fechaLlegada, cantidadPasajeros);
    }

    @Override
    public int compareTo(Vuelo v) {
        if (fechaLlegada == null)
            return 0;
        return getFechaLlegada().compareTo(v.getFechaLlegada());
    }
}
