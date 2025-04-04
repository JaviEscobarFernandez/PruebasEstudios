package videotutoria06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        // pruebaArrayList(lista);
        // pruebaIteradores(lista);
        // pruebaHashMap();
        // pruebaGenericos();
        // controlExcepciones(lista);
        // controlExcepciones2();
        delegacionExcepciones();
    }

    private static void pruebaArrayList(ArrayList<String> lista) {
        System.out.println("Probando ArrayList:");
        lista.add("Hola");
        lista.add("Mundo");
        System.out.println("Tamaño lista: " + lista.size());
        System.out.println("Indice de Hola: " + lista.indexOf("Hola"));
        lista.add("Hola");
        System.out.println("Tamaño lista: " + lista.size());
        System.out.println("Indice de Hola: " + lista.indexOf("Hola"));
        System.out.println((String)(lista.get(2)) + (String)(lista.get(0)));
        System.out.println(lista);
        lista.add(lista.size(), "Test");
        System.out.println(lista);
        System.out.println("Tamaño lista: " + lista.size());
        System.out.println(lista.get(2));
        lista.remove(2);
        System.out.println(lista.get(2));
        lista.add("Palabra2");
        lista.add("Palabra3");
        System.out.println(lista);
        String elementoRemove = lista.remove(0);
        System.out.println(elementoRemove);
    }

    private static void pruebaIteradores(ArrayList<String> lista) {
        System.out.println("Probando los iteradores recorriendo el ArrayList con bucle while: ");
        Iterator<String> itr = lista.iterator();
        while (itr.hasNext()) {
            String elemento = itr.next();
            System.out.println("Hay un elemento en la lista: " + elemento);
        }
        System.out.println("Probando los iteradores recorriendo el ArrayList con bucle for: ");
        // Iterar con bucle for (lo mismo que el while anterior)
        // una forma un tanto curiosa, creamos la variable vacia en el bucle for
        // comprobamos en cada iteracion si hay siguiente, pero incrementamos una vez entramos al bucle
        // para poder imprimir todos los elementos correctamente.
        itr = lista.iterator();
        for (String elemento = ""; itr.hasNext(); ) {
            elemento = itr.next();
            System.out.println("Hay un elemento en la lista: " + elemento);
        }
    }

    private static void pruebaHashMap() {
        System.out.println("Probando los HashMap");
        // Creamos un HashMap con los pares id - usuario
        Map <Integer, String> usuarios = new HashMap<>();
        // Le insertamos valores (como si los hubiese cargado de la bd)
        usuarios.put(1, "Aitor");
        usuarios.put(2, "Jose");
        usuarios.put(3, "Miguel");
        usuarios.put(4, "Javi");

        // Buscamos al usuario con id 3
        System.out.println("El usuario con ID 3 es: " + usuarios.get(3));
        if (usuarios.containsValue("Javi")) {
            System.out.println("El usuario Javi está en la BD");
        }

        // Recorremos todo el hashmap imprimiendo todos los resultados
        System.out.println("Mostrando todos los usuarios en la BD:");
        for (int id : usuarios.keySet()) {
            System.out.println("id: " + id + " - nombre: " + usuarios.get(id));
        }
        
        System.out.println("Probando a imprimir todo:");
        System.out.println(usuarios.entrySet());
    }

    private static void pruebaGenericos() {
        // Prueba de clase generica
        ClaseGenerica<Integer, String> generica = new ClaseGenerica<Integer, String>(10, "algo");
        generica.imprimirAtributos();
        ClaseGenerica<Integer, Character> generica2 = new ClaseGenerica<>(10, 'a');
        generica2.imprimirAtributos();
        // Prueba metodo estatico generico
        ClaseGenerica.sumar(19, 11);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduce un número que vamos a hacer una tabla de multiplicar con él:");
            double num1 = sc.nextDouble();
            sc.nextLine();
            System.out.print("\nIntroduce el valor máximo por el que vamos a multiplicar el número anterior:");
            int num2 = sc.nextInt();
            sc.nextLine();
            ClaseGenerica.tablaMultiplicar(num1, num2);
        } catch(Exception e) {
            System.err.println("ERROR: se han introducido datos inválidos. " + e);
            System.err.println("Finalizando la ejecución del programa.");
            System.exit(0);
        } finally {
            // Prueba para comprobar que si realizamos un System.exit en el manejo de excepciones, no llega a ejecutarse finally
            // Lo cual indica que primero se ejecuta los bloques de excepciones y por ultimo finally
            System.out.println("Cerrando scanner");
            sc.close();
        }
    }

    private static void controlExcepciones(ArrayList<String> lista) {
        System.out.println("Probando control de excepciones:");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nIntroduce el indice que quieres consultar en la lista: ");
            int indice = sc.nextInt();
            sc.nextLine();
            if (indice >= lista.size())
                throw new ExcepcionPersonalizada("El indice no puede ser superior a los elementos de la lista.");
            System.out.println("El contenido " + indice + " de la lista es: " + lista.get(indice));
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Se ha detectado la excepcion de indice fuera de limite: " + e.getMessage());
        }
        catch(ExcepcionPersonalizada e) {
            System.err.println("Se ha detectado la excepcion personalizada: " + e.getMessage());
        }
        catch(Exception e) {
            System.err.println("Detectada excepcion generica: " + e);
        }
        finally {
            System.out.println("Ejecutando codigo independientemente de la excepcion");
            System.out.println("Cerrando scanner aunque de excepcion");
            sc.close();
        }
        System.out.println("Hemos salido de la comprobacion de la excepcion.");
    }

    // probando a validar un dato de tipo numerico
    private static void controlExcepciones2() {
        // Ojo, scanner solo puede cerrarse una vez en toda la ejecucion, si lo cerramos antes, no podemos recabar mas datos de entrada
        Scanner sc = new Scanner(System.in);
        // Declaramos las variables a utilizar
        System.out.println("Vamos a jugar a \"Acertar el número:\"");
        Random random = new Random();
        int numRandom = random.nextInt(100); // entre 0 y 99
        int intentos = 10;
        int num = 0;

        // Ejecutamos el bucle hasta que consuma los intentos o lo acierte
        // En caso de acertar forzamos la finalizacion del bucle
        // Si no acierta restamos un intento y le indicamos si el valor introducido excede el numero o es menor.
        do {
            num = solicitarNumero(sc);
            if (num == numRandom)
                break;
            if (num > numRandom)
                System.out.println("El valor introducido es más alto que el número a adivinar, baja un poco ;)");
            else
                System.out.println("El valor introducido es más bajo que el número a adivinar, sube un poco ;)");
            --intentos;
        } while(intentos > 0);

        if (num == numRandom)
            System.out.println("Correcto!!! lo has adivinado, te han quedado " + intentos + " intentos restantes.");
        else
            System.out.println("Vaya, te has quedado sin intentos y no has acertado, que lástima.");
        sc.close();
    }

    // Al solicitar el numero lo validamos para que no intruduzca valores no deseados.
    private static int solicitarNumero(Scanner sc) {
        int num = -1;

        // Iteramos el bucle hasta que el usuario introduzca un valor adecuado.
        // Realizamos un manejo del control de excepciones para comprobar el valor introducido
        do {
            try {
                System.out.print("Introduce un número: ");
                num = sc.nextInt();
                if (num < 0 || num > 99) {
                    throw new ExcepcionPersonalizada("ERROR: debes introducir un valor comprendido entre 0 y 99");
                }
            } catch(ExcepcionPersonalizada e) {
                System.err.println(e.getMessage());
                num = -1; // Para volver a iterar el bucle, ya que es un valor no deseado
            } catch(Exception e) {
                System.err.println("ERROR: dato introducido no válido. Excepcion: " + e);
                num = -1; // Para volver a iterar el bucle, ya que es un valor invalido.
            } finally {
                // Pasamos a la siguiente linea scanner para asegurar
                sc.nextLine();
            }
        } while(num == -1);

        return num; // Retornamos el valor ya validado.
    }

    // Prueba de delegacion de exceciones
    private static void delegacionExcepciones() {
        int num1 = 10;
        int num2 = 0;
        System.out.println("intentando dividir " + num1 + " entre " + num2);
        // Dividir lanzara una excepcion por dividir entre 0, asi que lo manejamos aqui.
        try {
            int resultado = dividir(num1, num2);
            System.out.println("El resultado de dividir " + num1 + " entre " + num2 + " es: " + resultado);
        } catch (ArithmeticException  e) {
            System.err.println("ERROR: " + e);
        } finally {
            System.out.println("Manejo de excepciones realizado por delegacion.");
        }
    }

    private static int dividir(int num1, int num2) throws ArithmeticException  {
        // El error se produciria aqui, ya que estamos dividiendo entre 0
        // Pero en lugar de manejarlo aqui, lo enviamos con el throws ArithmeticException superior
        // al metodo que llama a dividir, es decir, lo manejamos en delagacionExcepciones()
        return num1 / num2;
    }
}
