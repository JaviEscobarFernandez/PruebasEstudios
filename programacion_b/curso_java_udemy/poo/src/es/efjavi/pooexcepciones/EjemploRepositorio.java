package es.efjavi.pooexcepciones;

import es.efjavi.pooexcepciones.excepciones.AccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.EscrituraAccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.LecturaAccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.RegistroDuplicadoAccesoDatoException;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Pérez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Lucy", "Martínez"));
            Cliente javi = new Cliente("Javi", "Escobar Fernández");
            repo.crear(javi);
            repo.crear(javi);

            repo.crear(null);
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
        } catch (RegistroDuplicadoAccesoDatoException e) {
            System.err.println("ERROR: registro duplicado " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e) {
            System.err.println("ERROR: lectura " + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e) {
            System.err.println("ERROR: escritura " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.err.println("ERROR: generico " + e.getMessage());
            e.printStackTrace();
        }
    }
}
