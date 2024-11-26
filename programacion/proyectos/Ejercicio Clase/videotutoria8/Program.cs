using System;
using libreria_vt08;

namespace videotutoria_8
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int num1 = 10;
            int num2 = 2;
            Console.WriteLine($"La suma de {num1} + {num2} es: {Operaciones.Sumar(num1, num2)}");
            Console.WriteLine($"La resta de {num1} - {num2} es: {Operaciones.Restar(num1, num2)}");
            Console.WriteLine($"La multiplicación de {num1} * {num2} es: {Operaciones.Multiplicar(num1, num2)}");
            Console.WriteLine($"La división de {num1} / {num2} es: {Operaciones.Dividir(num1, num2)}");
        }
    }
}
