package ejemplos;

public enum TipoCoche {
    SEDAN("Sedan", "Mediano", 4),
    STATION_WAGON("Station Wagon", "Grande", 5),
    HATCHBACK("Hatchback", "Compacto", 5),
    PICKUP("Pickup", "Camioneta", 4),
    COUPE("Coupé","Deportivo", 2),
    CONVERTIBLE("Convertible", "Deportivo", 2),
    FURGON("Furgón", "Utilitario", 3);

    private final String nombre;
    private final String descripcion;
    private final int numPuertas;

    TipoCoche(String nombre, String descripcion, int numPuertas) {
        this.nombre = nombre;
        this.numPuertas = numPuertas;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public int getNumPuertas() { return numPuertas; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return getNombre() + ", " + getDescripcion();
    }
}
