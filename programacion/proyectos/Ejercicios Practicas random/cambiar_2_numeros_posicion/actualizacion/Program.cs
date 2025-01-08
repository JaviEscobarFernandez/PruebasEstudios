using System;

namespace intercambiar_2_numeros_v2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Programa que solicita dos número de máximo 5 cifras y los intercambia de posicion
             * Realizado de forma modular y aplicadas validaciones
            */

            Console.WriteLine("Vamos a invertir las posiciones de los dos números que indiques.");
            int num1 = SolicitarNumero(true);
            int num2 = SolicitarNumero(false);
            Console.Write($"Los números 1º: {num1} y 2º: {num2} ");
            InvertirNumeros(ref num1, ref num2);
            Console.Write($"han sido invertidos 1º: {num1} y 2º: {num2}.");
        }

        static int SolicitarNumero(bool primero)
        {
            int numero = 0;
            bool valido = false;
            string posicion = primero ? "primer" : "segundo";
            do
            {
                Console.Write($"Introduce el {posicion} número de máximo 5 cifras: ");
                valido = ValidarNumero(Console.ReadLine(), ref numero);
                Console.WriteLine();
            }
            while (!valido);

            return numero;
        }
        static bool ValidarNumero(string dato, ref int numero)
        {
            if (!int.TryParse(dato, out numero))
            {
                Console.WriteLine("ERROR: dato introducido no válido.");
                return false;
            }
            if (numero < -99999 || numero > 99999)
            {
                Console.WriteLine("ERROR: Debes introducir un número mayor a 9 y que no supere las 5 cifras.");
                return false;
            }
            return true;
        }

        static void InvertirNumeros(ref int num1, ref int num2)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
    }
}
