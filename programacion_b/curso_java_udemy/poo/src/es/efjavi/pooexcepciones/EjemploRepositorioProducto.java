package es.efjavi.pooexcepciones;

import es.efjavi.pooexcepciones.excepciones.AccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.LecturaAccesoDatoException;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.62));
            repo.crear(new Producto("Silla", 18.36));
            repo.crear(new Producto("Lámpara", 15.02));
            repo.crear(new Producto("Reloj", 25.34));

            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);

            System.out.println("====== Paginable ======");
            List<Producto> paginable = repo.listar(2, 4);
            paginable.forEach(System.out::println);

            System.out.println("====== Ordenable ======");
            List<Producto> ordenable = repo.listar("descripcion", Direccion.ASC);
            // ordenable.forEach(System.out::println);
            for (Producto c : ordenable)
                System.out.println(c);

            System.out.println("====== Editar ======");
            Producto actualizarLampara = new Producto("Lámpara Salón", 40.51);
            actualizarLampara.setId(3);
            repo.editar(actualizarLampara);
            Producto lampara = repo.obtener(3);
            System.out.println(lampara);

            System.out.println("====== Ordenable 2 ======");
            List<Producto> ordenable2 = repo.listar("precio", Direccion.DESC);
            // ordenable.forEach(System.out::println);
            for (Producto c : ordenable2)
                System.out.println(c);

            System.out.println("======= Eliminar =======");
            repo.eliminar(3);
            repo.listar().forEach(System.out::println);

            System.out.println("======= Total ========");
            System.out.println("Total registros: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
