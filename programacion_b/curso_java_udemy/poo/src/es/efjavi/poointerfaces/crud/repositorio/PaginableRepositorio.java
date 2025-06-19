package es.efjavi.poointerfaces.crud.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int inicio, int fin);
}
