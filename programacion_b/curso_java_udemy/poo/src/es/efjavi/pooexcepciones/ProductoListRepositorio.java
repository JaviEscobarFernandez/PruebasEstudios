package es.efjavi.pooexcepciones;

import es.efjavi.pooexcepciones.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractClienteListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = obtener(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(dataSource);
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

    private static int ordenar(String campo, Producto a, Producto b) {
        int result = 0;
        switch (campo) {
            case "id" -> result = a.getId().compareTo(b.getId());
            case "descripcion" -> result = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> result = a.getPrecio().compareTo(b.getPrecio());
        }
        return result;
    }
}
