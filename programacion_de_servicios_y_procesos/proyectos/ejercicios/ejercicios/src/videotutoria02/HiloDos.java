package videotutoria02;

public class HiloDos extends Thread {
    private String nombre;

    HiloDos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Hilo con nombre: " + nombre + " tiene valor: " + i);
    }
}
