using System;

namespace piramide
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a formar una pirámide de *");
            int filas = 0;
            do
            {
                Console.Write("Introduce la altura de la pirámide (en filas): ");
                filas = ValidarNumero(Console.ReadLine());
            }
            while (filas <= 0);

            // Recorremos el total de filas:
            for (int i = 0; i < filas; i++)
            {
                // En cada fila primero imprimimos la cantidad de espacios
                // cada iteracion menos espacios, para centrar los *
                for (int j = filas; j >= i; j--)
                {
                    Console.Write(" ");
                }
                // Despues de los espacios añadimos los * correspondientes, con un espacio al final
                for (int k = 0; k <= i; k++)
                {
                    Console.Write("* ");
                }
                Console.WriteLine();
            }
        }
        static int ValidarNumero(string dato)
        {
            int filas = 0;
            if (!int.TryParse(dato, out filas))
            {
                Console.WriteLine("ERROR: Dato introducido no válido.");
                filas = 0;
                return filas;
            }
            if (filas <= 0 || filas > 20)
            {
                Console.WriteLine("ERROR: El máximo de filas debe ser un número entre 1 y 20.");
                filas = 0;
            }
            return filas;
        }
    }
}
