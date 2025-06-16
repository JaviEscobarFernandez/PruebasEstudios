package es.efjavi.catalogo.producto;

public class Iphone extends Electronico {
    private String modelo;
    private String color;

    public Iphone(int precio, String fabricante, String modelo, String color) {
        super(precio, fabricante);
        this.modelo = modelo;
        this.color = color;
    }

    public String getModelo() { return modelo; }
    public String getColor() { return color; }

    @Override
    public double getPrecioVenta() { return getPrecio(); }

    @Override
    public String toString() {
        return "Tipo: Iphone\n" + getDatos();
    }

    @Override
    public String getDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modelo: ").append(getModelo()).append("\n")
                .append("Color: ").append(getColor()).append("\n")
                .append("Fabricante: ").append(getFabricante()).append("\n")
                .append("Precio de venta: ").append(getPrecioVenta()).append("€");
        return sb.toString();
    }
}
