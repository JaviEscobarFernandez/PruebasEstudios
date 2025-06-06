package ejemplos;

public class Coche implements Comparable<Coche> {
    private String fabricante;
    private String modelo;
    private Color color;
    private Motor motor;
    private Deposito deposito;
    private Persona conductor;
    private Rueda[] ruedas;
    private int guidRueda;

    private TipoCoche tipo;
    private int id;
    static private int idAutoIncrement;

    static final int MAX_VELOCIDAD_CARRETERA = 140;
    static final int MAX_VELOCIDAD_CIUDAD = 60;

    public Coche() {
        this("null", "null", Color.BLANCO);
    }

    public Coche(String fabricante, String modelo, Color color) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.motor = new Motor(3.0, TipoMotor.GASOLINA);
        this.deposito = new Deposito();
        tipo = TipoCoche.SEDAN;
        this.ruedas = new Rueda[5];
        idAutoIncrement += 1;
        id = idAutoIncrement;
    }

    public Coche(String fabricante, String modelo, Color color, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public Coche(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
        tipo = TipoCoche.SEDAN;
    }

    public Coche(String fabricante, String modelo, Color color, Motor motor, Deposito deposito, TipoCoche tipo) {
        this(fabricante, modelo, color, motor);
        this.deposito = deposito;
        this.tipo = tipo;
    }

    public Coche(String fabricante, String modelo, Color color, Motor motor, Deposito deposito, TipoCoche tipo, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, deposito, tipo);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public String getFabricante() { return fabricante; }
    public String getModelo() { return modelo; }
    public Color getColor() { return color; }
    public TipoCoche getTipo() { return tipo; }
    public int getId() { return id; }
    public Motor getMotor() { return motor; }
    public Deposito getDeposito() { return deposito; }
    public Persona getConductor() { return conductor; }
    public Rueda[] getRuedas() { return ruedas; }

    public void setFabricante(String f) { fabricante = f; }
    public void setModelo(String m) { modelo = m; }
    public void setColor(Color c) { color = c; }
    public void setTipo(TipoCoche t) { tipo = t; }
    public void setMotor(Motor motor) { this.motor = motor; }
    public void setDeposito(Deposito deposito) { this.deposito = deposito; }
    public void setConductor(Persona conductor) { this.conductor = conductor; }
    public void setRuedas(Rueda[] ruedas) { this.ruedas = ruedas; }

    public void addRueda(Rueda rueda) {
        if (guidRueda < getRuedas().length)
            this.ruedas[guidRueda++] = rueda;
    }

    public String acelerar(int rpm) {
        return "El coche " + getFabricante() + " " + getModelo() + " " + getColor().getColor() +
                " acelera a: " + rpm + " rpm";
    }

    public String frenar() {
        return "El coche " + getFabricante() + " " + getModelo() + " " + getColor().getColor() + " frena.";
    }

    public float calcularConsumo(int km, float pctCombustible) {
        return km / (deposito.getCapacidad() * pctCombustible);
    }

    public float calcularConsumo(int km, int pctCombustible) {
        return km / (deposito.getCapacidad() * (pctCombustible / 100f));
    }

    public void imprimirDatosCoche() {
        String datos = "Fabricante: " + getFabricante() +
                "\nModelo: " + getModelo() +
                "\nColor: " + getColor().getColor() +
                "\nCilindrada: " + motor.getCilindrada() +
                "\nCapacidad Deposito: " + motor.getCilindrada() +
                "\nTipo: " + getTipo().toString() +
                "\nIdentificador: " + getId() +
                "\n";
        System.out.println(datos);
    }

    public static int verValorAutoincrement() { return idAutoIncrement; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coche))
            return false;

        if (this == obj)
            return true;

        Coche a = (Coche)obj;
        return this.getFabricante().equals(a.getFabricante())
            && this.getModelo().equals((a.getModelo()));
    }

    @Override
    public String toString() {
        return "Coche{" +
                "fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color.getColor() + '\'' +
                ", cilindrada=" + motor.getCilindrada() +
                ", capacidad deposito=" + deposito.getCapacidad() +
                ", Tipo=" + tipo.toString() +
                '}';
    }

    @Override
    public int compareTo(Coche c) {
        return getFabricante().compareTo(c.getFabricante());
    }
}
