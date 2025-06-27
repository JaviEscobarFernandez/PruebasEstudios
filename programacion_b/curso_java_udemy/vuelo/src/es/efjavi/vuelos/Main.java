package es.efjavi.vuelos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        List<Vuelo> vuelos = new ArrayList<>();

        calendar.set(2021, Calendar.AUGUST, 29, 5, 39);
        vuelos.add(new Vuelo("AAL 933", "New York", "Santiago", calendar.getTime(), 62));

        calendar.set(2021, Calendar.AUGUST, 31, 4, 45);
        vuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", calendar.getTime(), 47));

        calendar.set(2021, Calendar.AUGUST, 30, 16, 0);
        vuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", calendar.getTime(), 52));

        calendar.set(2021, Calendar.AUGUST, 29, 13, 22);
        vuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", calendar.getTime(), 59));

        calendar.set(2021, Calendar.AUGUST, 31, 14, 5);
        vuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", calendar.getTime(), 25));

        calendar.set(2021, Calendar.AUGUST, 31, 5, 20);
        vuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", calendar.getTime(), 29));

        calendar.set(2021, Calendar.AUGUST, 30, 8, 45);
        vuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago", calendar.getTime(), 55));

        calendar.set(2021, Calendar.AUGUST, 29, 7, 41);
        vuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", calendar.getTime(), 51));

        calendar.set(2021, Calendar.AUGUST, 30, 10, 35);
        vuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", calendar.getTime(), 48));

        calendar.set(2021, Calendar.AUGUST, 29, 9, 14);
        vuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", calendar.getTime(), 59));

        calendar.set(2021, Calendar.AUGUST, 31, 8, 33);
        vuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", calendar.getTime(), 31));

        calendar.set(2021, Calendar.AUGUST, 31, 15, 15);
        vuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", calendar.getTime(), 29));

        calendar.set(2021, Calendar.AUGUST, 30, 8, 14);
        vuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", calendar.getTime(), 47));

        calendar.set(2021, Calendar.AUGUST, 29, 22, 53);
        vuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", calendar.getTime(), 60));

        calendar.set(2021, Calendar.AUGUST, 31, 9, 57);
        vuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", calendar.getTime(), 32));

        calendar.set(2021, Calendar.AUGUST, 31, 4, 0);
        vuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago", calendar.getTime(), 35));

        calendar.set(2021, Calendar.AUGUST, 29, 7, 45);
        vuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", calendar.getTime(), 61));

        calendar.set(2021, Calendar.AUGUST, 30, 7, 12);
        vuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", calendar.getTime(), 58));

        calendar.set(2021, Calendar.AUGUST, 29, 18, 29);
        vuelos.add(new Vuelo("LAT 501", "París", "Santiago", calendar.getTime(), 49));

        calendar.set(2021, Calendar.AUGUST, 30, 15, 45);
        vuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", calendar.getTime(), 39));

        System.out.println("Imprimiendo lista de vuelos ordenada por fecha de llegada:");
        vuelos.sort(Comparator.comparing(Vuelo::getFechaLlegada));
        vuelos.forEach(System.out::println);

        Vuelo ultimoVuelo = null;
        Vuelo menorPasajerosVuelo = null;
        for (Vuelo v : vuelos) {
            if (ultimoVuelo == null) {
                ultimoVuelo = v;
            }
            if (menorPasajerosVuelo == null) {
                menorPasajerosVuelo = v;
            }
            if (ultimoVuelo.getFechaLlegada().compareTo(v.getFechaLlegada()) < 0)
                ultimoVuelo = v;
            if (menorPasajerosVuelo.getCantidadPasajeros() > v.getCantidadPasajeros())
                menorPasajerosVuelo = v;
        }

        System.out.println();
        System.out.println("Ultimo vuelo en llegar: " + ultimoVuelo);
        System.out.println("Vuelo con menor número de pasajeros: " + menorPasajerosVuelo);
    }
}