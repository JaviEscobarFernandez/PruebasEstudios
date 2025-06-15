package company;

public class Empleado extends Persona{
    private double remuneracion;
    private int empleadoId;
    private static int autoincrement;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = ++autoincrement;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int pct) { remuneracion += (pct * remuneracion) / 100; }

    @Override
    public String toString() {
        return super.toString() + "\nremuneracion=" + remuneracion +
                ", empleadoId=" + empleadoId + '\'';
    }
}
