package es.efjavi.colecciones.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Julian");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "España");
        direccion.put("provincia", "Valencia");
        direccion.put("ciudad", "Xirivella");
        direccion.put("calle", "San Ramón");
        direccion.put("numero", "20");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);
    }
}
