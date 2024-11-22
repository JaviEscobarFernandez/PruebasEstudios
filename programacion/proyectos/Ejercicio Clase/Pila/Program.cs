using System;

namespace Pila
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
            * Vamos a crear un programa para trabajar con una pila. Una pila es una estructura de datos que nos permite guardar un conjunto de variables.
            * La característica fundamental es que el último elemento que se añade al conjunto es el primero que se puede sacar.
            * Para representar una pila vamos a utilizar un array de tipo string con tamaño 10, por lo tanto la pila no podrá tener más de 10 elementos.
            * Vamos a crear varias funciones para trabajar con la pila:

            InicializarPila: Como tenemos un array de 10 posiciones tenemos que inicializarlo e introducir un carácter(por ejemplo un* que indique que ese elemento del array no corresponde con un dato de la pila. Esta función inicializa el vector con ese carácter.
            LongitudPila: Función que recibe una pila y devuelve el número de elementos que tiene.
            EstaVaciaPila: Función que recibe una pila y que devuelve si la pila está vacía, no tiene elementos.
            EstaLlenaPila: Función que recibe una pila y que devuelve si la pila está llena.
            AddPila: función que recibe una cadena de caracteres y una pila, y añade la cadena a la pila, si no está llena.si esta llena muestra un mensaje de error.
            SacarDeLaPila: Función que recibe una pila y devuelve el último elemento añadido y lo borra de la pila.Si la pila está vacía muestra un mensaje de error.
            EscribirPila: Función que recibe una pila y muestra en pantalla los elementos de la pila.

            * Finalmente, realiza un programa principal que nos permita usar las funciones anterior, que nos muestre un menú, con las siguientes opciones:

            Añadir elemento a la pila
            Sacar elemento de la pila
            Longitud de la pila
            Mostrar pila
            Salir

            */

            // Creamos el vector de la pila y lo inicializamos
            string[] pilaVector = new string[10];
            InicializarPila(pilaVector);

            // Creamos el menu con las opciones
            string opcion = "";
            Console.WriteLine("Hola, en este programa manejaremos una Pila.");
            do
            {
                Console.WriteLine("\n\n**Por favor, elige una opción:**");
                Console.WriteLine("- Añadir elemento a la pila - Introduce: 1");
                Console.WriteLine("- Sacar elemento de la pila - Introduce: 2");
                Console.WriteLine("- Longitud de la pila - Introduce: 3");
                Console.WriteLine("- Mostrar pila - Introduce: 4");
                Console.WriteLine("- Salir - Introduce: S");
                opcion = Console.ReadLine().ToUpper();

                switch (opcion)
                {
                    case "1":
                        Console.Write("Introduce el elemento que quieres añadir a la Pila: ");
                        AddPila(Console.ReadLine(), pilaVector);
                        break;
                    case "2":
                    {
                        string resultPila = SacarDeLaPila(pilaVector);
                        if (resultPila != "*")
                            Console.WriteLine($"El elemento que se ha sacado de la pila es: {resultPila}");
                        break;
                    }
                    case "3":
                        Console.WriteLine($"El tamaño de elementos de la pila es: {LongitudPila(pilaVector)}");
                        break;
                    case "4":
                        EscribirPila(pilaVector);
                        break;
                    case "S":
                        Console.WriteLine("¡Adios!");
                        break;
                    default:
                        Console.WriteLine("ERROR: dato introducido no válido.");
                        break;
                }
            }
            while (opcion != "S");
        }

        static void InicializarPila(string[] pilaVector)
        {
            // Recorremos el vector recien creado y le asignamos el valor * por defecto, que representa sin valor en nuestro programa.
            for (int i = 0; i < pilaVector.Length; i++)
                pilaVector[i] = "*";
        }

        static int LongitudPila(string[] pilaVector)
        {
            int count = 0;
            // Recorremos el vector y contamos los elementos que tengan un valor asignado, retornamos dicha cuenta.
            foreach (string p in pilaVector)
            {
                if (p != "*")
                    count++;
            }
            return count;
        }

        static bool EstaVaciaPila(string[] pilaVector)
        {
            int count = 0;
            // Recorremos el vector y contamos los elementos que tengan un valor asignado, si la cuenta es 0, retornamos true.
            foreach (string p in pilaVector)
            {
                if (p != "*")
                    count++;
            }
            return count == 0;
        }

        static bool EstaLlenaPila(string[] pilaVector)
        {
            int count = 0;
            // Recorremos el vector y contamos los elementos que tengan un valor asignado, si la cuenta es el tamaño del vector, retornamos true.
            foreach (string p in pilaVector)
            {
                if (p != "*")
                    count++;
            }
            return count == pilaVector.Length;
        }

        static void AddPila(string valor, string[] pilaVector)
        {
            // Comprobamos si la pila esta llena, en ese caso indicamos error.
            if (EstaLlenaPila(pilaVector))
            {
                Console.WriteLine("ERROR: La pila está llena, no se puede introducir más elementos.\n");
                return;
            }

            // Buscamos el primer hueco libre disponible y establecemos el valor.
            for (int i = 0; i < pilaVector.Length; i++)
            {
                if (pilaVector[i] == "*")
                {
                    pilaVector[i] = valor;
                    break;
                }
            }
            Console.WriteLine("Elemento añadido correctamente a la pila.\n");
        }
        static string SacarDeLaPila(string[] pilaVector)
        {
            string valorPila = "*";
            // Comprobamos si la pila esta vacia, en ese caso indicamos error.
            if (EstaVaciaPila(pilaVector))
            {
                Console.WriteLine("ERROR: La pila está vacía, no se puede vaciar.\n");
                return valorPila;
            }

            // Buscamos el ultimo valor añadido, lo eliminamos y retornamos dicho elemento
            for (int i = pilaVector.Length - 1; i >= 0; i--)
            {
                if (pilaVector[i] != "*")
                {
                    valorPila = pilaVector[i];
                    pilaVector[i] = "*";
                    break;
                }
            }

            return valorPila;
        }

        static void EscribirPila(string[] pilaVector)
        {
            Console.WriteLine("Los elementos de la pila son (ordenados empezando por el ultimo elemento añadido): ");
            // Recorremos el vector a la inversa y mostramos los elementos que no esten sin asignar ("*")
            for (int i = pilaVector.Length - 1; i >= 0; i--)
            {
                if (pilaVector[i] != "*")
                    Console.WriteLine("- " + pilaVector[i]);
            }
            Console.WriteLine("");
        }
    }
}
