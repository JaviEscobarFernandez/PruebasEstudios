package es.efjavi.poointerfaces.crud.repositorio.lista;

import es.efjavi.poointerfaces.crud.modelo.Cliente;
import es.efjavi.poointerfaces.crud.repositorio.AbstractClienteListRepositorio;
import es.efjavi.poointerfaces.crud.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractClienteListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.obtener(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellidos(cliente.getApellidos());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
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
}
