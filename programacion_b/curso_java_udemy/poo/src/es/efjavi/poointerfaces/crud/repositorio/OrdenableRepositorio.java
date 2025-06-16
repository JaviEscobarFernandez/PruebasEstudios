package es.efjavi.poointerfaces.crud.repositorio;

import es.efjavi.poointerfaces.crud.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listarClientes(String campo, Direccion dir);
}
