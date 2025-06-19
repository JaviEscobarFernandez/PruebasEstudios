package es.efjavi.pooexcepciones;

import es.efjavi.pooexcepciones.excepciones.EscrituraAccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.LecturaAccesoDatoException;
import es.efjavi.pooexcepciones.excepciones.RegistroDuplicadoAccesoDatoException;

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
    public T obtener(Integer id) throws LecturaAccesoDatoException {
        if (id == null || id <= 0)
            throw new LecturaAccesoDatoException("ID no válido, debe ser mayor a 0");

        T resultado = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                resultado = c;
                break;
            }
        }

        if (resultado == null)
            throw new LecturaAccesoDatoException("Registro con id: " + id + " no existente");
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if (t == null)
            throw new EscrituraAccesoDatoException("Error al insertar un objeto nulo");
        if (dataSource.contains(t))
            throw new RegistroDuplicadoAccesoDatoException("Error el objeto con id " + t.getId() +
                    " existe en el repositorio.");
        dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        dataSource.remove(obtener(id));
    }

    @Override
    public List<T> listar(int inicio, int fin) {
        return dataSource.subList(inicio, fin);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
