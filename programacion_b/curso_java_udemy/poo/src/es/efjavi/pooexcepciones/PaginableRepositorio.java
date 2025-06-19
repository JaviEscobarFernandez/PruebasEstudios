package es.efjavi.pooexcepciones;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int inicio, int fin);
}
