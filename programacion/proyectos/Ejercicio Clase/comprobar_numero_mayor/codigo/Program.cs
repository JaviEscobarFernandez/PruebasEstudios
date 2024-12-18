using System;

namespace comprobar_numero_mayor
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a comprobar si el primer numero es mayor al segundo.");
            int x = SolicitarNumero();
            int y = SolicitarNumero();
            CompararNumeros(x, y);
        }

        static int SolicitarNumero()
        {
            int num = -1;
            do
            {
                Console.Write("Introduce el número: ");
                string dato = Console.ReadLine();
                num = ValidarNumero(dato);
            }
            while (num < 0);

            return num;
        }

        static int ValidarNumero(string dato)
        {
            int num = 0;
            if (int.TryParse(dato, out num) && num >= 0)
                return num;

            Console.WriteLine("ERROR: Dato introducido no válido, debe ser un número positivo.");
            return -1;
        }

        static void CompararNumeros(int x, int y)
        {
            if (x > y)
                Console.WriteLine($"{x} es mayor que {y}");
            else if (x == y)
                Console.WriteLine($"{x} es igual que {y}");
            else
                Console.WriteLine($"{x} es menor que {y}");
        }
    }
}
