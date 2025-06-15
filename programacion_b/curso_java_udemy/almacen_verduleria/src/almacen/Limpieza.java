package almacen;

public class Limpieza extends Producto {
    private String componentes;
    private double litros;

    public Limpieza(String nombre, double precio, String componentes, double litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() { return componentes; }
    public double getLitros() { return litros; }

    @Override
    public String toString() {
        System.out.println("Producto de tipo: Limpieza");
        return super.toString() + "\nDetalles:\nComponentes: " + getComponentes() + ", Litros: " + getLitros();
    }
}
