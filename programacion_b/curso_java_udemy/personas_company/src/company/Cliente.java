package company;

public class Cliente extends Persona{
    private int clienteId;
    private static int autoincrement;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = ++autoincrement;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return super.toString() + "clienteId=" + clienteId;
    }
}
