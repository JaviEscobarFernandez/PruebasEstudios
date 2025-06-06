package ejemplos;

public enum Color {
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    VERDE("Verde"),
    AZUL("Azul"),
    NARANJA("Naranja"),
    BLANCO("Blanco"),
    NEGRO("Negro"),
    PLATA("Plata");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() { return color; }
}
