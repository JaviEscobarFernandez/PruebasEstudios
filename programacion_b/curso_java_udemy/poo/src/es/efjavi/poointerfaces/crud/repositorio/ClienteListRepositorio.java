package es.efjavi.poointerfaces.crud.repositorio;

import es.efjavi.poointerfaces.crud.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {
    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listarClientes() {
        return dataSource;
    }

    @Override
    public Cliente getCliente(Integer id) {
        Cliente cliente = null;
        for (Cliente c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        dataSource.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente c = this.getCliente(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellidos(cliente.getApellidos());
    }

    @Override
    public void eliminarCliente(Integer id) {
        Cliente cliente = getCliente(id);
        if (cliente != null)
            dataSource.remove(cliente);
    }

    @Override
    public List<Cliente> listarClientes(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(dataSource);
        listaOrdenada.sort((a, b) -> {
            int result = 0;
            if (dir == Direccion.ASC)
                result = ordenar(campo, a, b);
            else
                result = ordenar(campo, b, a);
            return result;
        });
        return listaOrdenada;
    }

    private static int ordenar(String campo, Cliente a, Cliente b) {
        int result = 0;
        switch (campo) {
            case "id" -> result = a.getId().compareTo(b.getId());
            case "nombre" -> result = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> result = a.getApellidos().compareTo(b.getApellidos());
        }
        return result;
    }

    @Override
    public List<Cliente> listarCliente(int inicio, int fin) {
        return dataSource.subList(inicio, fin);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
