package ejemplos;

public class EjemploCocheRelaciones {
    public static void main(String[] args) {
        Persona conductorCoche1 = new Persona("Luci", "Martinez");
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
        coche1.setConductor(conductorCoche1);
        Rueda[] ruedasCoche1 = new Rueda[5];
        for (int i = 0; i < ruedasCoche1.length; i++){
            coche1.addRueda(new Rueda("Yokohama", 16, 7.5));
        }
        // coche1.setRuedas(ruedasCoche1);
        System.out.println("Imprimiendo datos del coche creado por defecto y modificado posteriormente:");
        coche1.imprimirDatosCoche();
        System.out.println("Kilómetros por litro: " + coche1.calcularConsumo(300, 70));

        System.out.println("Conductor coche1: " + coche1.getConductor());
        System.out.println("Ruedas del coche1:");
        for (Rueda r : coche1.getRuedas()) {
            System.out.println(r.getInfo());
        }
        Persona conductorCoche2 = new Persona("Paco", "Rodriguez");
        Rueda[] ruedasCoche2 =  new Rueda[5];
        for (int i = 0; i < ruedasCoche2.length; i++) {
            ruedasCoche2[i] = new Rueda("Michelin", 10, 10.5);
        }
        Coche coche2 = new Coche("Opel", "Astra", Color.PLATA, new Motor(3.0, TipoMotor.DIESEL), new Deposito(60), TipoCoche.SEDAN, conductorCoche2, ruedasCoche2);
        System.out.println("Creado un coche específico, imprimiendo sus datos:");
        coche2.imprimirDatosCoche();
        System.out.println(coche2.acelerar(100));
        System.out.println(coche2.frenar());

        System.out.println("Kilómetros por litro: " + coche2.calcularConsumo(300, 0.64f));

        Persona conductorCoche3 = new Persona("Bea", "González");
        Rueda[] ruedasCoche3 = { new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5) };
        Coche coche3 = new Coche("Opel", "Astra", Color.NEGRO, conductorCoche3, ruedasCoche3);

        System.out.println("coche2 es igual a coche3? " + coche2.equals(coche3));

        Persona conductorCoche4 = new Persona("Lorenzo", "Perez");
        Rueda[] ruedasCoche4 = { new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5),
                new Rueda("Pirelli", 10, 10.5) };
        Coche coche4 = new Coche("Opel", "Astra", Color.NEGRO, conductorCoche4, ruedasCoche4);
        System.out.println("coche4 es igual a coche3? " + coche4.equals(coche3));
        coche3.imprimirDatosCoche();
        coche4.imprimirDatosCoche();

        System.out.println(coche4.toString());

        System.out.println("Ver valor actual del id autoincrement: " + Coche.verValorAutoincrement());
        System.out.println("Velocidad máxima carretera: " + Coche.MAX_VELOCIDAD_CARRETERA);
        System.out.println("Velocidad máxima ciudad: " + Coche.MAX_VELOCIDAD_CIUDAD);
    }
}
