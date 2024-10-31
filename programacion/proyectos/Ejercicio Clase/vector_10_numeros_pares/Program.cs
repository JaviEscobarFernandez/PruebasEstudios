using System;

namespace vector_10_numeros_pares
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Declarar vector (array unidimensional) de numeros enteros de tamaño 10
            int[] vector10 = new int[10];

            // Pedir que introduzca por teclado los 10 valores
            Console.WriteLine("Hola, vamos a almacenar 10 valores y comprobaremos cuales son pares.");
            for (int i = 0; i < vector10.Length; i++)
            {
                Console.WriteLine("Introduce el valor numero: " + i);
                int valor = 0;
                if (!Int32.TryParse(Console.ReadLine(), out valor))
                {
                    Console.WriteLine("Dato introducido no valido, establecemos este valor a 1.");
                    vector10[i] = 1;
                    continue;
                }
                vector10[i] = valor;
            }

            // contamos los numeros pares que tiene el vector y lo mostramos por pantalla
            int pares = 0;
            foreach (int valorVector in vector10)
            {
                if (valorVector % 2 == 0)
                    pares++;
            }
            Console.WriteLine($"La cantidad de numeros pares introducidos es: {pares}");
        }
    }
}
