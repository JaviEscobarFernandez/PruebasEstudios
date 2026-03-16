package videotutoria02;

public class Hilo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hilo tiene valor: " + i);
    }
}
