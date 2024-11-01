using System;

namespace triangulo_rectangulo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // solicitar por consola 1 numero
            Console.Write("Hola, vamos a generar un triangulo rectangulo, por favor, introduce la longitud de sus lados: ");

            // guardar el numero solicitado en variable cateto
            int cateto = 0;
            if (!int.TryParse(Console.ReadLine(), out cateto))
            {
                Console.WriteLine("Dato no válido.");
                return;
            }

            // comprobar que cateto sea mayor a 0
            if (cateto <= 0)
            {
                Console.WriteLine("El valor debe ser mayor a 0");
                return;
            }

            // imprimir con asteriscos un triangulo rectangulo, la longitud de los lados sera la variable cateto
            for (int i = cateto; i > 0; i--)
            {
                for (int j = i; j > 0; j--)
                    Console.Write("*");
                Console.WriteLine("");
            }

            // Otra forma de realizarlo:
            for (int i = 0; i < cateto; i++)
            {
                for (int j = 0; j < (cateto - i); j++)
                    Console.Write("*");
                Console.WriteLine("");
            }
        }
    }
}
