package es.efjavi.generics;

import es.efjavi.poointerfaces.crud.modelo.Cliente;
import es.efjavi.poointerfaces.crud.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Javi", "Escobar Fernández"));
        Cliente javi = clientes.iterator().next();
        System.out.println(javi);

        Cliente[] clientesArray = { javi, new Cliente("Pepe", "Flores") };
        Integer[] enterosArray = { 1, 2, 3 };

        List<Cliente> clientesList = fromArrayToList(clientesArray);
        List<Integer> enterosList = fromArrayToList(enterosArray);

        clientesList.forEach(System.out::println);
        enterosList.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[] { "Javi", "Lola", "Marta", "Dario" }, enterosArray);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremiumList = fromArrayToList(new ClientePremium[] {
                new ClientePremium("Paco", "Tous"),
                new ClientePremium("Manolo", "Gonzalez")
        });
        imprimirClientes(clientes);
        imprimirClientes(clientesList);
        imprimirClientes(clientesPremiumList);

        System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Máximo de Zanahoria, Arándanos, Manzana es: "
            + maximo("Zanahoria", "Arándano", "Manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0)
            max = b;
        else if (c.compareTo(a) > 0)
            max = c;
        return max;
    }
}
