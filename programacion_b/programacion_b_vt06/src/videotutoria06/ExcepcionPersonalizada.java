package videotutoria06;

public class ExcepcionPersonalizada extends Exception {
    // Id de excepcion personalizada
    private static final long serialVersionUID = 6325905832476626132L;

    public ExcepcionPersonalizada(String msg) {
        super(msg);
    }
}
