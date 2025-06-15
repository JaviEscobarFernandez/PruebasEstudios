package almacen;

public class Cliente extends Persona {
    private int idCliente;
    private static int autoincrement;

    public Cliente(String nombre, String apellidos, String DNI) {
        super(nombre, apellidos, DNI);
        this.idCliente = ++autoincrement;
    }

    public int getIdCliente() { return idCliente; }

    @Override
    public String toString() {
        return super.toString() + "\nIdentificador del Cliente: " + getIdCliente();
    }
}
