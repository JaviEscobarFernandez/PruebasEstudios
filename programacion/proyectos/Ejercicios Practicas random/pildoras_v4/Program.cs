using System;

namespace pildoras_v4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // pruebaArrayEdades();
            // pruebasArrays();
            // PruebaArrayProcesar();
            PruebaArrayLeerImprimirDatos();
        }

        // Prueba inicial de arrays
        static void pruebaArrayEdades()
        {
            // Declaramos array de 4 posiciones vacia
            int[] edades = new int[4];

            // Comprobamos como por defecto imprime las edades con valor 0.
            for (int i = 0; i < edades.Length; i++)
                Console.WriteLine($"Edad nº{i + 1}: {edades[i]}");

            int edadInicial = 20;
            // Actualizamos los valores del array
            for (int j = 0; j < edades.Length; j++)
            {
                edades[j] = edadInicial + j;
            }

            int count = 0;
            foreach (int a in edades)
            {
                count++;
                Console.WriteLine("Edad nº{0}: {1}", count, a);
            }
        }

        // Pruebas arrays mas avanzadas
        static void pruebasArrays()
        {
            string[] prueba = new string[] { "prueba1", "prueba2" };
            double[] numeros = new double[] { 1, 2, 3.4, 10, 10.4 };

            // Array implicito (lo convierte al tipo de datos automaticamente segun el contenido)
            var prueba2 = new[] { "prueba1", "prueba2" };
            var numeros2 = new[] { 1, 2, 3.4, 10, 10.4 };

            // Array de objetos
            Empleados Ana = new Empleados("Ana", 35);
            Empleados[] arrayEmpleados = new Empleados[2];
            arrayEmpleados[0] = new Empleados("Julia", 31);
            arrayEmpleados[1] = Ana;

            // Array de tipos o clases anonimas
            var personas = new[]
            {
                new { Nombre = "Juan",  Edad = 19 },
                new { Nombre = "Maria", Edad = 24 },
                new { Nombre = "Diana", Edad = 34 }
            };
            Console.WriteLine(personas[1]);

            // Dos formas de utilizar el bucle for para recorrer el array
            for (int i = 0; i < 5; i++)
            {
                Console.Write($"{numeros[i]}\t");
            }

            Console.WriteLine();

            for (int i = 0; i < numeros2.Length; i++)
                Console.Write($"{numeros2[i]}\t");

            Console.WriteLine();

            // Tambien probamos con foreach
            foreach (double n in numeros)
                Console.Write($"{n}\t");

            Console.WriteLine();

            for (int i = 0; i < arrayEmpleados.Length; i++)
            {
                Console.WriteLine($"Nombre empleado: {arrayEmpleados[i].nombre}, edad: {arrayEmpleados[i].edad}");
                Console.WriteLine(arrayEmpleados[i].getInfo());
            }

            Console.WriteLine();

            foreach (Empleados e in arrayEmpleados)
            {
                Console.WriteLine($"Nombre empleado: {e.nombre}, edad: {e.edad}");
                Console.WriteLine(e.getInfo());
            }

            Console.WriteLine();

            // Usamos foreach para recorrer personas utilizando var en lugar del tipo de datos concreto
            foreach (var p in personas)
                Console.WriteLine(p);

            Console.WriteLine();
        }

        class Empleados
        {
            public Empleados(string nombre, int edad)
            {
                this.nombre = nombre;
                this.edad = edad;
            }

            public string getInfo()
            {
                return "Nombre empleado: " + nombre + ", edad: " + edad;
            }

            // Si en vez de public fuesen private, no podriamos acceder fuera de empleados,
            // asi que el primer bucle for de arrayEmpleados no podria utilizarse.
            // Si solo utilizamos getInfo, podrian ser private
            public string nombre;
            public int edad;
        }

        static void PruebaArrayProcesar()
        { 
            int[] numeros = new int[4];
            numeros[0] = 7;
                numeros[1] = 2;
                numeros[2] = 3;
                numeros[3] = 6;

                ProcesarDatos(numeros);
            Console.WriteLine();

                int[] numeros2 = new int[] { 2, 4, 12, 3 };
            ProcesarDatos(numeros2, true);
            Console.WriteLine();
        }

        static void ProcesarDatos(int[] datos, bool aumentarValor = false)
        {
            if (aumentarValor)
            {
                for (int i = 0; i < 4; i++)
                    datos[i] += 10;
            }

            foreach (int dato in datos)
            {
                Console.WriteLine(dato);
            }
        }

        // Prueba array final para crear un metodo que genera un array y lo devuelve
        static void PruebaArrayLeerImprimirDatos()
        {
            int[] elementos = LeerDatosArray();
            foreach (int e in elementos)
                Console.Write($"{e}\t");
            Console.WriteLine();
        }

        static int[] LeerDatosArray()
        {
            Console.WriteLine("¿Cuantos elementos quieres que tenga el array?");
            string respuesta = Console.ReadLine();
            int numRespuesta = int.Parse(respuesta);
            int[] arrayDatos = new int[numRespuesta];

            for (int i = 0; i < arrayDatos.Length; i++)
            {
                Console.WriteLine($"Introduce el dato para la posición {i}: ");
                respuesta = Console.ReadLine();
                int datosElemento = int.Parse(respuesta);
                arrayDatos[i] = datosElemento;
            }
            return arrayDatos;
        }
    }
}
