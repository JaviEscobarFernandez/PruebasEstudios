package ejemplos;

import java.util.Arrays;

public class EjemploCocheArray {
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
        Rueda[] ruedasCoche1 =  new Rueda[5];
        for (int i = 0; i < ruedasCoche1.length; i++) {
            ruedasCoche1[i] = new Rueda("Dunlop", 10, 10.5);
        }
        coche1.setRuedas(ruedasCoche1);
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

        Coche coche3 = new Coche("Audi", "TT", Color.ROJO);
        coche3.setConductor(new Persona("Javi", "Escobar Fernández"));

        Coche[] coches = new Coche[3];
        coches[0] = coche1;
        coches[1] = coche2;
        coches[2] = coche3;

        Arrays.sort(coches);
        for (Coche c : coches) {
            System.out.println("c = " + c);
        }
    }
}
