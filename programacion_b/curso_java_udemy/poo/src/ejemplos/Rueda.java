package ejemplos;

public class Rueda {
    private String fabricante;
    private int diametro;
    private double ancho;

    public Rueda(String fabricante, int diametro, double ancho) {
        this.fabricante = fabricante;
        this.diametro = diametro;
        this.ancho = ancho;
    }

    public String getFabricante() { return fabricante; }
    public int getDiametro() { return diametro; }
    public double getAncho() { return ancho; }

    public String getInfo() {
        return getFabricante() + ", diametro: " + getDiametro() + ", ancho" + getAncho();
    }
}
