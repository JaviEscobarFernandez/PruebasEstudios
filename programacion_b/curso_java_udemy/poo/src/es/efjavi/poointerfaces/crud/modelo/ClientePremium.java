package es.efjavi.poointerfaces.crud.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium> {
    public ClientePremium(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}
