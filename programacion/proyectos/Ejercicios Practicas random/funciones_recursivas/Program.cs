using System;
using System.Security.Cryptography;

namespace temp_test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Funcion recursiva para generar el factorial de un numero y una secuencia de N numeros naturales
            int numero = SolicitarNumero();
            Console.WriteLine($"El factorial de {numero} es: {GenerarFactorial(numero)}");
            Console.WriteLine($"Los {numero} numeros naturales de {numero} son: {GenerarNatural(numero)}");
        }

        private static int SolicitarNumero()
        {
            int num = 0;
            Console.WriteLine("Hola, vamos a calcular el factorial de un numero y sus numeros naturales.");
            do
            {
                Console.Write("introduce un número del 1 al 10: ");
                if (!int.TryParse(Console.ReadLine(), out num))
                {
                    Console.WriteLine("ERROR: Dato introducido no válido, debe ser un número del 1 al 10.");
                    num = 0;
                }
            }
            while (num == 0);
            return num;
        }

        private static int GenerarFactorial(int numero)
        {
            // Caso base, en caso de ser 1, finalizamos
            if (numero == 1)
                return numero;
            // Caso recursivo
            return numero * GenerarFactorial(numero - 1);
        }

        private static string GenerarNatural(int numero)
        {
            return GenerarNatural(1, numero);
        }

        private static string GenerarNatural(int numero, int count)
        {
            string naturales = "";
            if (numero > 1)
                naturales = " ";
            // Caso base, en caso de ser 1, finalizamos
            if (count == 1)
                return naturales + numero;
            // Caso recursivo
            return naturales + numero + GenerarNatural(++numero, --count);
        }
    }
}
