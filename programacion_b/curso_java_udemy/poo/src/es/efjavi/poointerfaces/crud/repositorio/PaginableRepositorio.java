package es.efjavi.poointerfaces.crud.repositorio;

import es.efjavi.poointerfaces.crud.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listarCliente(int inicio, int fin);
}
