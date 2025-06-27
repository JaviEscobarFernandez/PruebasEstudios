package es.efjavi.colecciones.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>();
        System.out.println("Contiene elementos? " + !persona.isEmpty());
        persona.put(null, "1234");
        persona.put(null, "1234");
        persona.put("nombre", "John");
        persona.put("nombre", "John dos");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Julian");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "España");
        direccion.put("provincia", "Valencia");
        direccion.put("ciudad", "Xirivella");
        direccion.put("calle", "San Ramón");
        direccion.put("numero", "20");

        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "San Juan");
        System.out.println("El país de " + persona.get("nombre") + " es: " + pais);
        System.out.println("La ciudad de " + persona.get("nombre") + " es: " + ciudad);
        System.out.println("El barrio de " + persona.get("nombre") + " es: " + barrio);

        String valorApellido = (String) persona.remove("apellidoPaterno");
        System.out.println("eliminado " + valorApellido);
        // boolean b = persona.remove("apellidoPaterno", "Julian");
        // System.out.println("eliminado " + b);
        System.out.println("persona = " + persona);

        boolean b2 = persona.containsKey("apellidoPaterno");
        System.out.println("b2 = " + b2);

        b2 = persona.containsValue("Doe");
        System.out.println("b2 = " + b2);

        System.out.println("Iterando con Collection");
        Collection<Object> valores = persona.values();
        for (Object v : valores) {
            System.out.println("v = " + v);
        }

        System.out.println("Iterando con set keyset");
        Set<String> claves = persona.keySet();
        for (String c : claves) {
            System.out.println("c = " + c);
        }

        System.out.println("Iterando con Map.Entry");
        for (Map.Entry<String, Object> par : persona.entrySet()) {
            Object valor = par.getValue();
            if (valor instanceof Map) {
                String name = persona.get("nombre").toString();
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for (Map.Entry<String, String> parDir : direccionMap.entrySet()) {
                    System.out.println(parDir.getKey() + " => " + parDir);
                }
            }
            else
                System.out.println(par.getKey() + " => " + valor);
        }

        System.out.println("Iterando clave y buscando valor");
        for (String clave : persona.keySet()) {
            Object valor = persona.get(clave);
            if (valor instanceof Map) {
                String name = persona.get("nombre").toString();
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El país de " + name + ": " + direccionMap.get("pais"));
                System.out.println("La ciudad de " + name + ": " + direccionMap.get("ciudad"));
                System.out.println("La provincia de " + name + ": " + direccionMap.get("provincia"));
            }
            else
                System.out.println(clave + " => " + valor);
        }

        System.out.println("Iterando con foreach de Java8");
        persona.forEach((clave, valor) -> System.out.println(clave + " => " + valor));

        System.out.println("total " + persona.size());
        System.out.println("Contiene elementos? " + !persona.isEmpty());
        persona.replace("nombre", "John dos", "Javi");
        System.out.println("persona = " + persona);
    }
}
