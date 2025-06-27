package es.efjavi.colecciones.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {
        String[] peces = { "Corvina", "Atún", "Lenguado", "Atún", "Rodaballo", "Mero", "Lenguado" };
        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        for (String pez : peces) {
            if (!unicos.add(pez))
                duplicados.add(pez);
        }
        unicos.removeAll(duplicados);
        System.out.println("Únicos: " + unicos);
        System.out.println("Duplicados: " + duplicados);
    }
}
