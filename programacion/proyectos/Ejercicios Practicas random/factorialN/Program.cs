using System;

namespace factorialN
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Realizar factorial de un numero con funcion recursiva
            // El factorial de un número n se calcula: n! = n * (n - 1) * (n - 2) * (n - 3) * … * 1

            // Solicitar numero
            int numero = SolicitarNumero();

            // Calcular factorial (lo hacemos al imprimir el resultado)

            // Imprimir resultado
            Console.WriteLine($"El factorial de {numero} es: {CalcularFactorial(numero)}");
        }

        static int SolicitarNumero()
        {
            int num = 0;
            Console.WriteLine("Hola, vamos a calcular el factorial de un número.");
            do
            {
                Console.Write("Introduce un numero: ");
                num = ValidarNumero(Console.ReadLine());
            }
            while (num <= 0);

            return num;
        }

        static int ValidarNumero(string datos)
        {
            int num = 0;
            if (!int.TryParse(datos, out num))
                num = -1;

            // Lo limitamos a 12 para que no exceda el limite de int32
            if (num <= 0 || num > 12)
            {
                num = 0;
                Console.WriteLine("ERROR: número introducido no válido, por favor indica un número entre 1 y 12");
            }

            return num;
        }

        static int CalcularFactorial(int numero)
        {
            // Ambas funcionan, pero dejo la mas decente
            // int totalFactorial = 1;
            // return Factorial(numero, totalFactorial);
            return Factorial(numero);
        }

        // Primer intento
        static int Factorial(int numero, int totalFactorial)
        {
            // Caso base seria n*1
            if (numero <= 1)
                return totalFactorial;
            // Caso generico n*(n-1)
            totalFactorial *= numero;
            numero--;
            return Factorial(numero, totalFactorial);
        }
        // Forma mas decente
        static int Factorial(int numero)
        {
            // Caso base seria n*1
            if (numero <= 1)
                return 1;
            // Caso generico n*(n-1)
            return numero * Factorial(numero - 1);
        }
    }
}
