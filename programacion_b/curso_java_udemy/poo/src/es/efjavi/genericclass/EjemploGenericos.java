package es.efjavi.genericclass;

public class EjemploGenericos {
    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addObjeto(new Animal("Peregrino", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Secretaria", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Chiquito", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Sargento", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Rayo", "Caballo"));
        System.out.println("Imprimiendo contenido de transporte de animales:");
        imprimirCamion(transporteCaballos);
        System.out.println();

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.addObjeto(new Maquinaria("Bulldozer"));
        transMaquinas.addObjeto(new Maquinaria("Grúa horquilla"));
        transMaquinas.addObjeto(new Maquinaria("Perforadora"));
        System.out.println("Imprimiendo contenido de transporte de maquinaria:");
        imprimirCamion(transMaquinas);
        System.out.println();

        Camion<Coche> transAuto = new Camion<>(3);
        transAuto.addObjeto(new Coche("Toyota"));
        transAuto.addObjeto(new Coche("Ferrari"));
        transAuto.addObjeto(new Coche("Opel"));
        System.out.println("Imprimiendo contenido de transporte de coches:");
        imprimirCamion(transAuto);
        System.out.println();
    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T t : camion) {
            if (t instanceof Animal) {
                Animal a = (Animal) t;
                System.out.println(a.getNombre() + " tipo " + a.getTipo());
            }
            else if (t instanceof Maquinaria) {
                Maquinaria m = (Maquinaria) t;
                System.out.println(m.getTipo());
            }
            else if (t instanceof Coche) {
                Coche c = (Coche) t;
                System.out.println(c.getMarca());
            }
        }
    }

}
