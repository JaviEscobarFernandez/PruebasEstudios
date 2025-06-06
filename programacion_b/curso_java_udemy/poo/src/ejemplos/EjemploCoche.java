package ejemplos;

public class EjemploCoche {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        System.out.println("Creado un coche por defecto, imprimiendo sus datos:");
        coche1.imprimirDatosCoche();

        System.out.println("Modificando valores del coche creado por defecto:");
        coche1.setFabricante("Ferrari");
        coche1.setModelo("SF90 XX");
        coche1.setColor(Color.ROJO);
        Motor motorFerrari = new Motor(2.0, TipoMotor.DIESEL);
        coche1.setMotor(motorFerrari);
        coche1.setDeposito(new Deposito());
        coche1.setTipo(TipoCoche.COUPE);
        System.out.println("Imprimiendo datos del coche creado por defecto y modificado posteriormente:");
        coche1.imprimirDatosCoche();
        System.out.println("Kilómetros por litro: " + coche1.calcularConsumo(300, 70));

        Coche coche2 = new Coche("Opel", "Astra", Color.PLATA, new Motor(3.0, TipoMotor.DIESEL), new Deposito(60), TipoCoche.SEDAN);
        System.out.println("Creado un coche específico, imprimiendo sus datos:");
        coche2.imprimirDatosCoche();
        System.out.println(coche2.acelerar(100));
        System.out.println(coche2.frenar());

        System.out.println("Kilómetros por litro: " + coche2.calcularConsumo(300, 0.64f));

        Coche coche3 = new Coche("Opel", "Astra", Color.NEGRO);

        System.out.println("coche2 es igual a coche3? " + coche2.equals(coche3));
        Coche coche4 = new Coche("Opel", "Astra", Color.NEGRO);
        System.out.println("coche4 es igual a coche3? " + coche4.equals(coche3));
        coche3.imprimirDatosCoche();
        coche4.imprimirDatosCoche();

        System.out.println(coche4.toString());

        System.out.println("Ver valor actual del id autoincrement: " + Coche.verValorAutoincrement());
        System.out.println("Velocidad máxima carretera: " + Coche.MAX_VELOCIDAD_CARRETERA);
        System.out.println("Velocidad máxima ciudad: " + Coche.MAX_VELOCIDAD_CIUDAD);

        TipoCoche tipoOpel = coche3.getTipo();
        switch (tipoOpel) {
            case CONVERTIBLE ->
                System.out.println("El coche es deportivo y descapotable de dos puertas");
            case COUPE ->
                System.out.println("Es un coche pequeño de dos puertas y típicamente deportivo");
            case FURGON ->
                System.out.println("Es un coche utilitario de transporte, uso para empresa");
            case HATCHBACK ->
                System.out.println("Es un coche mediano compacto, de aspecto deportivo");
            case PICKUP ->
                System.out.println("Es un coche de doble cabina o camioneta");
            case SEDAN ->
                System.out.println("Es un coche mediano");
            case STATION_WAGON ->
                System.out.println("Es un coche más grande, con maletero amplio");
            default ->
                System.out.println("Tipo inválido");
        }

        TipoCoche[] tipos = TipoCoche.values();
        for (TipoCoche t : tipos) {
            System.out.println(t + " => " + t.name() + ", " + t.getNombre() +
                    ", " + t.getDescripcion() + ", " + t.getNumPuertas());
        }
    }
}
