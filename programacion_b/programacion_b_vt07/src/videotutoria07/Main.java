package videotutoria07;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        ejercicio01();
        ejemploFileWriter();
        ejemploFileReader();
        ejemploBufferedReader();
        ejercicio02();
    }

    private static void ejercicio01() {
        /*
         * Crea un programa en Java que cree un directorio llamado EjercicioUF5 en
         * la ruta C:\M03B y que cree un fichero de texcto llamado miFichero.txt en
         * la ruta C:\M03B\EjerciciosUF5
         */

        // Diferentes formas de establecer la ruta para crear el directorio
        // Todas son validas, hemos utilizado la doble \ en este caso concreto.
        // String separador = File.separator;
        // String ruta = "C:\\M03B";
        // String ruta2 = "C:" + separador + "M03B";
        // File directorioInicial = new File(ruta);
        // File directorioInicial = new File(ruta2);
        File directorioInicial = new File("C:\\M03B");
        // Utilizamos un procedimiento para crearlo, asi reutilizamos el control de excepciones
        crearDirectorio(directorioInicial);


        // Lo podemos crear asi directamente, pero podemos utilizar al objeto instanciado
        // Ya que ira dentro de dicha ruta el segundo directorio que vamos a instanciar.
        // File directorioEjercicios = new File("C:\\M03B\\EjerciciosUF5");
        // El objeto que vamos a instanciar, hasta que no utilicemos el mkdir o el createNewFile
        // No se sabra si es directorio o fichero, segun el tratamiento que le damos al crearlo
        // Una vez lo hemos instanciado, sera de un tipo o de otro.
        File directorioEjercicios = new File(directorioInicial, "EjerciciosUF5");
        crearDirectorio(directorioEjercicios);

        File miFichero = new File(directorioEjercicios, "miFichero.txt");
        try {
            if (!miFichero.createNewFile())
                throw new IOException("Error al crear el fichero " + miFichero.getName());
            System.out.println("Fichero " + miFichero.getName() + " creado correctamente.");
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Generando stack trace:");
            e.printStackTrace(); // Aqui imprimimos la trazabilidad del error generado.
        }
    }

    private static void crearDirectorio(File directorio) {
        // Podemos tratar con un if si se crea o no directamente el fichero o directorio
        // Pero mejor utilizar un try catch y manejar la excepcion lanzando la excepcion
        try {
            if (!directorio.mkdir()) // Creamos el directorio inicial
                throw new IOException("Error al crear el directorio " + directorio.getName());
            System.out.println("Directorio " + directorio.getName() + " creado correctamente");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            // System.exit(1); // En caso de no crearse, forzamos a finalizar el programa (0 = sin error, 1 = con error)
        }
    }

    private static void ejemploFileWriter() {
        System.out.println("Probando FileWriter:");

        File miFichero = new File("C:\\M03B\\EjerciciosUF5", "miFichero.txt");
        try {
            // abrimos flujo para operar en el fichero (al no poner 2º parametro true, no hace append), por lo que sobreescribimos
            // si estuviese en true, empezaria a escribir al final del fichero.
            FileWriter fw = new FileWriter(miFichero);
            fw.write("Hola mundo, prueba");
            fw.flush(); // Volcamos lo que tiene almacenado write previamente en el fichero.
            fw.close(); // cerramos el flujo
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    private static void ejemploFileReader() {
        System.out.println("\n\nProbando FileReader:");

        File miFichero = new File("C:\\M03B\\EjerciciosUF5", "miFichero.txt");
        try {
            FileReader fr = new FileReader(miFichero); // Abrimos el flujo para leer en el fichero
            int c = 0;
            // Iteramos el int llamado c, fr.read va a devolver en codigo ASCII el numero del caracter que esta leyendo
            // En caso de ser -1 significa que ya ha llegado al final, por lo que terminará de iterar el bucle.
            while ((c = fr.read()) != -1) {
                System.out.print((char)c); // Hacemos un cast del int c a char para convertir el codigo ASCII al caracter e imprimirlo.
            }
            fr.close(); // Cerramos el flujo, ya hemos acabado
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    private static void ejemploBufferedReader() {
        System.out.println("\n\nProbando BufferedReader:");

        File miFichero = new File("C:\\M03B\\EjerciciosUF5", "miFichero2.txt");
        try {
            FileReader fr = new FileReader(miFichero);
            BufferedReader buffer = new BufferedReader(fr);
            String linea = "";
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
            buffer.close();
            fr.close();
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    private static void ejercicio02() {
        /*
         * Crea un programa en Java que, a partir del fichero miFichero de los ejercicios y ejemplos anteriores,
         * modifique su contenido sustituyendo la palabra Mundo por Onliners.
         * Tendrás que hacer uso de BufferedReader y de BufferedWriter.
         */
        // Utilizamos miFichero para leerlo y creamos un nuevo miFicheroNuevo para escribir ahi el texto reemplazado
        File miFichero = new File("C:\\M03B\\EjerciciosUF5", "miFichero.txt");
        File miFichero2 = new File("C:\\M03B\\EjerciciosUF5", "miFicheroNuevo.txt");
        try {
            FileReader fr = new FileReader(miFichero);         // abrimos flujo de lectura para miFichero
            BufferedReader bufferR = new BufferedReader(fr);   // creamos un buffer de lectura para miFichero
            FileWriter fw = new FileWriter(miFichero2);        // abrimos un flujo de escritura para miFicheroNuevo
            BufferedWriter bufferW = new BufferedWriter(fw);   // creamos un buffer de escritura para miFicheroNuevo

            String linea = "";
            // Buscamos en el buffer donde hemos volcado el contenido de miFichero linea a linea
            while ((linea = bufferR.readLine()) != null) {
                linea = linea.replace("mundo", "Onliners"); // Reemplazamos mundo por Onliners si esta en esa linea
                bufferW.write(linea); // Escribimos en miFicheroNuevo el contenido de la linea (haya sido o no modificado)
                bufferW.newLine(); // Añadimos un salto de linea (aunque no es necesario)
            }

            bufferW.flush(); // volcamos el contenido del buffer en miFicheroNuevo para asegurar que se ha escrito
            // cerramos siempre en orden inverso a su apertura
            bufferW.close(); // cerramos buffer de esritura
            fw.close();      // cerramos flujo de escritura
            bufferR.close(); // cerramos buffer de lectura
            fr.close();      // cerramos flujo de esritura
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}
