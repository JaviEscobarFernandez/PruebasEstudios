using System;

namespace videotutoria_02_suma_numeros_1_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Realiza un programa que sume los números del 1 al 5. Debes emplear un bucle.
            // Después, comprueba su funcionamiento con una tabla de pensamiento computacional.

            Console.WriteLine("Tabla de pensamiento computacional:");
            Console.WriteLine("----------------------");
            Console.WriteLine("|   cont  |   suma   |");
            Console.WriteLine("----------------------");
            int suma = 0;
            for (int cont = 0; cont <= 5; cont++)
            {
                suma += cont;
                // Simplemente para visualizar mejor el resultado en la tabla
                string sumaResult = suma < 10 ? " " + suma.ToString() : suma.ToString();
                Console.WriteLine($"| cont: {cont} | suma: {sumaResult} |");
            }
            Console.WriteLine("----------------------");
            Console.WriteLine($"El resultado es: {suma}");
        }
    }
}
