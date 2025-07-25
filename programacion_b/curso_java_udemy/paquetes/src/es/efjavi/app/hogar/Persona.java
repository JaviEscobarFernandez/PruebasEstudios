package es.efjavi.app.hogar;

public class Persona {
    private String nombre;
    private String apellido;
    private ColorPelo colorPelo;

    public static final String GEN_MASCULINO = "Masculino";
    public static final String GEN_FEMENINO = "Femenino";

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public ColorPelo getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(ColorPelo colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String lanzarPelota() {
        return "Lanza la pelota al perro!";
    }

    public static String saludar() {
        return "Hola, buenas tardes";
    }
}
