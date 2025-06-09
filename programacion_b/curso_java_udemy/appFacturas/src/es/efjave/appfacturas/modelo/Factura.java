package es.efjave.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItem;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() { return folio; }

    public String getDescripcion() { return descripcion;}
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente c) { cliente = c; }

    public ItemFactura[] getItems() { return items; }
    public void addItemFactura(ItemFactura item) {
        if (indiceItem < MAX_ITEMS)
            this.items[indiceItem++] = item;
    }

    public double calcularTotal() {
        double total = 0.0;
        ItemFactura[] items = getItems();
        for (int i = 0; i < indiceItem; i++) {
            total += items[i].calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura Nº: ")
                .append(getFolio())
                .append("\nCliente: ")
                .append(getCliente().getNombre())
                .append("\t DNI: " + cliente.getDni())
                .append("\nDescripción: " + getDescripcion())
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat(("dd 'de' MMMM, yyyy"));
        sb.append("Fecha Emisión: ")
                .append(df.format(getFecha()))
                .append("\n")
                .append("\n#\tNombre\t€\tCant.\tTotal\n");

        ItemFactura[] items = getItems();
        for (int i = 0; i < indiceItem; i++) {
            sb.append(items[i].toString()).append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal())
                .append("€");

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
