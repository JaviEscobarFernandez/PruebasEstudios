package es.efjavi.poointerfaces.crud.repositorio;

import es.efjavi.poointerfaces.crud.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClienteListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {
    protected List<T> dataSource;

    public AbstractClienteListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T obtener(Integer id) {
        T resultado = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                resultado = c;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) { dataSource.add(t); }

    @Override
    public void eliminar(Integer id) { dataSource.remove(obtener(id)); }

    @Override
    public List<T> listar(int inicio, int fin) {
        return dataSource.subList(inicio, fin);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
