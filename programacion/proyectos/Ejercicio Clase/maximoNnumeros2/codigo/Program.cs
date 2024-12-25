using System;

namespace maximoNNumeros2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int max = 0;
            int numero = 0;
            Console.WriteLine("Hola, vamos a calcular el máximo de N numeros.");
            do
            {
                Console.Write("Introduce un número (negativo para finalizar): ");
                numero = ValidarNumero(Console.ReadLine());
                if (numero > max)
                    max = numero;
            }
            while (numero >= 0);
            Console.WriteLine($"El número máximo es: {max}");
        }

        static int ValidarNumero(string datos)
        {
            int numero = 0;
            if (!int.TryParse(datos, out numero))
            {
                Console.WriteLine("ERROR: dato introducido no válido.");
                numero = 0;
            }
            return numero;
        }
    }
}
