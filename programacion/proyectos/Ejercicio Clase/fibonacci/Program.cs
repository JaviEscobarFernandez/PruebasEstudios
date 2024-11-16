using System;

namespace fibonacci
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Recoger por consola un numero entero y validar su valor.
            int numeroObtenido = ObtenerNumero();

            // Creamos un vector (array unidimensional) para almacenar la secuencia fibonacci
            int[] vectorFibonacci = new int[numeroObtenido];
            GenerarFibonacci(ref vectorFibonacci);

            // Mostramos secuencia Fibonacci
            ImprimirFibonacci(vectorFibonacci);
        }

        static int ObtenerNumero()
        {
            int numero = -1;
            do
            {
                // Pedimos por consola que introduzca el numero
                Console.Write("Hola, vamos a calcular Fibonacci, por favor, introduce un numero: ");
                // Comprobamos que el dato introducido sea valido, de lo contrario, mostramos mensaje de error y volvemos a empezar.
                if (!int.TryParse(Console.ReadLine(), out numero))
                {
                    numero = -1;
                    continue;
                }

                if (numero < 7 || numero > 22)
                {
                    numero = -1;
                    Console.WriteLine("ERROR: Valor introducido no válido, debe ser un numero entero entre 7 y 22.\nVolvemos a empezar.");
                    continue;
                }
            }
            while (numero <= 0);

            return numero;
        }

        static void GenerarFibonacci(ref int[] vectorFibonacci)
        {
            // Creamos las dos primeras variables que son los primeros numeros de la secuencia fibonacci
            int value1 = 0;
            int value2 = 1;
            for (int i = 0; i < vectorFibonacci.Length; i++)
            {
                // Almacenamos en el vector el primer valor
                vectorFibonacci[i] = value1;
                // Actualizamos el primer valor al segundo valor
                value1 = value2;
                // Sumamos la copia del primer valor al segundo valor
                value2 += vectorFibonacci[i];
            }
        }

        static void ImprimirFibonacci(int[] vectorFibonacci)
        {
            foreach (int i in vectorFibonacci)
            {
                Console.Write(i + " ");
            }

            // Salto de linea
            Console.Write("\n");

            // Mostramos secuencia Fibonacci invertida
            for (int i = vectorFibonacci.Length - 1; i >= 0; i--)
            {
                Console.Write(vectorFibonacci[i] + " ");
            }

            // Salto de linea
            Console.WriteLine("");
        }
    }
}
