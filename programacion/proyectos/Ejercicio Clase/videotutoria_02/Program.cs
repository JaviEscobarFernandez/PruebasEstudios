using System;

namespace videotutoria_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ImprimirImpares();
            Console.WriteLine();
            ImprimirFactorial();
        }

        static void ImprimirImpares()
        {
            Console.WriteLine("Hola, vamos a calcular los numeros impares del 1 al n.");
            // Solicitamos el numero para obtener el maximo (n).
            int numero = SolicitarNumero(1, 99);

            // Ya hemos obtenido el numero n, vamos a calcular los impares
            Console.WriteLine($"Los números impares del 1 al {numero} son: ");

            // Utilizamos contador para mostrar en cada linea un maximo de 5 numeros.
            int contador = 0;

            // Recorremos los numeros y dividimos entre 2, si el resto es diferente a 0, es impar
            for (int i = 0; i <= numero; i++)
            {
                if (i % 2 != 0)
                {
                    contador++;
                    if (contador >= 5)
                    {
                        contador = 0;
                        Console.WriteLine($"{i}\t");
                    }
                    else
                        Console.Write($"{i}\t");
                }
            }
        }

        static void ImprimirFactorial()
        {
            Console.WriteLine("Hola, vamos a calcular el factorial de n.");
            int numero = SolicitarNumero(1, 10);
            int result = 1;
            for (int i = 1; i <= numero; i++)
            {
                result *= i;
            }
            Console.WriteLine($"El factorial de {numero} es: {result}");
        }

        static int SolicitarNumero(int min, int max)
        {
            int numero = 0;
            do
            {
                Console.Write($"\nPor favor, introduce un número del {min} al {max}: ");
                numero = ValidarNumero(Console.ReadLine(), min, max);
            }
            while (numero == 0);

            return numero;
        }

        static int ValidarNumero(string s, int min, int max)
        {
            int numero = 0;
            if (!int.TryParse(s, out numero))
            {
                Console.WriteLine("ERROR: El dato introducido no es válido");
                numero = 0;
            }
            else if (numero < min || numero > max)
            {
                Console.WriteLine($"ERROR: El dato introducido debe ser un número entre {min} y {max}");
                numero = 0;
            }
            return numero;
        }
    }
}
