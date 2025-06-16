package es.efjavi.poointerfaces.crud.repositorio;

import es.efjavi.poointerfaces.crud.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> listarClientes();
    Cliente getCliente(Integer id);
    void crearCliente(Cliente cliente);
    void editarCliente(Cliente cliente);
    void eliminarCliente(Integer id);
}
