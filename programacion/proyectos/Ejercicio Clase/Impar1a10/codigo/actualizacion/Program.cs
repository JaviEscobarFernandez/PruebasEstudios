using System;

namespace impares_1_10
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Mostrar números impares del 1 al 10:");
            for (int i = 0; i < 10; i++)
            {
                if (i % 2 != 0) { Console.WriteLine(i); }
            }
        }
    }
}
