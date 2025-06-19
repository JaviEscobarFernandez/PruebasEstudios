package es.efjavi.poointerfaces.crud.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T obtener(Integer id);
    void crear(T t);
    void editar(T t);
    void eliminar(Integer id);
}
