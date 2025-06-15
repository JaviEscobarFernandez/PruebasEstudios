package es.efjavi.pooherencia;

public class Alumno extends Persona {
    private String institucion;
    private double notaMatematicas;
    private double notaLenguaje;
    private double notaHistoria;

    public Alumno() {
        System.out.println("Alumno: Inicializando constructor...");
    }

    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion) {
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion,
                  double notaMatematicas, double notaLenguaje, double notaHistoria) {
        this(nombre, apellido, edad, institucion);
        this.notaMatematicas = notaMatematicas;
        this.notaLenguaje = notaLenguaje;
        this.notaHistoria = notaHistoria;
    }
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematicas() {
        return notaMatematicas;
    }

    public void setNotaMatematicas(double notaMatematicas) {
        this.notaMatematicas = notaMatematicas;
    }

    public double getNotaLenguaje() {
        return notaLenguaje;
    }

    public void setNotaLenguaje(double notaLenguaje) {
        this.notaLenguaje = notaLenguaje;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar() {
        String saludar = super.saludar();
        return saludar + "soy el alumno: " + getNombre();
    }

    public double calcularPromedio() {
        System.out.println("calcularPromedio " + Alumno.class.getCanonicalName());
        return (notaHistoria + notaLenguaje + notaMatematicas) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\ninstitucion='" + institucion + '\'' +
                ", notaMatematicas=" + notaMatematicas +
                ", notaLenguaje=" + notaLenguaje +
                ", notaHistoria=" + notaHistoria +
                ", promedio=" + this.calcularPromedio();
    }
}
