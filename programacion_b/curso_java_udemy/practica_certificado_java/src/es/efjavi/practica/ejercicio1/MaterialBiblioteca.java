package es.efjavi.practica.ejercicio1;

public abstract class MaterialBiblioteca {
    private String idMaterial;

    public MaterialBiblioteca(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getIdMaterial() { return idMaterial; }

    public abstract String obtenerTipoMaterial();

    @Override
    public String toString() {
        return "idMaterial: " + idMaterial;
    }
}
