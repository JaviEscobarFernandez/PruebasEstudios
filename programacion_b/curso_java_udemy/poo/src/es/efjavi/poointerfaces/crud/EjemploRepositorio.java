package es.efjavi.poointerfaces.crud;

import es.efjavi.poointerfaces.crud.modelo.Cliente;
import es.efjavi.poointerfaces.crud.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crearCliente(new Cliente("Jano", "Pérez"));
        repo.crearCliente(new Cliente("Bea", "González"));
        repo.crearCliente(new Cliente("Lucy", "Martínez"));
        repo.crearCliente(new Cliente("Javi", "Escobar Fernández"));

        List<Cliente> clientes = repo.listarClientes();
        clientes.forEach(System.out::println);

        System.out.println("====== Paginable ======");
        List<Cliente> paginable = repo.listarCliente(2, 4);
        paginable.forEach(System.out::println);

        System.out.println("====== Ordenable ======");
        List<Cliente> ordenable = repo.listarClientes("nombre", Direccion.ASC);
        // ordenable.forEach(System.out::println);
        for (Cliente c : ordenable)
            System.out.println(c);

        System.out.println("====== Editar ======");
        Cliente actualizarBea = new Cliente("Bea", "Mena González");
        actualizarBea.setId(2);
        repo.editarCliente(actualizarBea);
        Cliente bea = repo.getCliente(2);
        System.out.println(bea);

        System.out.println("====== Ordenable 2 ======");
        List<Cliente> ordenable2 = repo.listarClientes("apellidos", Direccion.DESC);
        // ordenable.forEach(System.out::println);
        for (Cliente c : ordenable2)
            System.out.println(c);

        System.out.println("======= Eliminar =======");
        repo.eliminarCliente(2);
        repo.listarClientes().forEach(System.out::println);

        System.out.println("======= Total ========");
        System.out.println("Total registros: " + repo.total());
    }
}
