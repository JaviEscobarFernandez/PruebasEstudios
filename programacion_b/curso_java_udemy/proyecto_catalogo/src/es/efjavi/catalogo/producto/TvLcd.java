package es.efjavi.catalogo.producto;

public class TvLcd extends Electronico {
    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() { return pulgada; }

    @Override
    public double getPrecioVenta() { return getPrecio(); }

    @Override
    public String toString() {
        return "Tipo: TvLcd\n" + getDatos();
    }

    @Override
    public String getDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pulgadas: ").append(getPulgada()).append("\n")
                .append("Fabricante: ").append(getFabricante()).append("\n")
                .append("Precio de venta: ").append(getPrecioVenta()).append("€");
        return sb.toString();
    }
}
