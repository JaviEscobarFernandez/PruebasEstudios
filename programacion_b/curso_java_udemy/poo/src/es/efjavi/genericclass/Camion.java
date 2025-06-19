package es.efjavi.genericclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T> {
    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        objetos = new ArrayList<>();
    }

    public void addObjeto(T o) {
        if (objetos.size() <= max)
            objetos.add(o);
        else
            throw new RuntimeException("No hay espacio disponible");
    }

    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
