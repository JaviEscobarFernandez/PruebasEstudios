package es.efjavi.pooexcepciones;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int autoincrement;

    public BaseEntity() {
        this.id = ++autoincrement;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity cliente = (BaseEntity) o;
        return Objects.equals(id, cliente.id);
    }
}
