package es.efjavi.poointerfaces.crud;

import es.efjavi.poointerfaces.crud.modelo.Cliente;
import es.efjavi.poointerfaces.crud.repositorio.*;
import es.efjavi.poointerfaces.crud.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "González"));
        repo.crear(new Cliente("Lucy", "Martínez"));
        repo.crear(new Cliente("Javi", "Escobar Fernández"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("====== Paginable ======");
        List<Cliente> paginable = repo.listar(2, 4);
        paginable.forEach(System.out::println);

        System.out.println("====== Ordenable ======");
        List<Cliente> ordenable = repo.listar("nombre", Direccion.ASC);
        // ordenable.forEach(System.out::println);
        for (Cliente c : ordenable)
            System.out.println(c);

        System.out.println("====== Editar ======");
        Cliente actualizarBea = new Cliente("Bea", "Mena González");
        actualizarBea.setId(2);
        repo.editar(actualizarBea);
        Cliente bea = repo.obtener(2);
        System.out.println(bea);

        System.out.println("====== Ordenable 2 ======");
        List<Cliente> ordenable2 = repo.listar("apellidos", Direccion.DESC);
        // ordenable.forEach(System.out::println);
        for (Cliente c : ordenable2)
            System.out.println(c);

        System.out.println("======= Eliminar =======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("======= Total ========");
        System.out.println("Total registros: " + repo.total());
    }
}
