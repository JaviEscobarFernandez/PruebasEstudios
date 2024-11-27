using System;

namespace numeros_aleatorios
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Programa que genera 20 numeros aleatorios pidiendo dos valores (minimo y maximo).

            // Solicitar los dos numeros
            int minimo = 0;
            int maximo = 0;
            SolicitarNumeros(ref minimo, ref maximo);

            // Generar numeros aleatorios
            int[] numerosAleatorios = new int[20];
            GenerarNumerosAleatorios(numerosAleatorios, minimo, maximo);

            // Imprimir resultado
            for (int i = 0; i < numerosAleatorios.Length; i++)
            {
                if (i > 0 && i % 5 == 0)
                {
                    // Salto de linea en caso de ser el quinto valor (5 valores mostrados por fila)
                    Console.WriteLine();
                }
                Console.Write(numerosAleatorios[i] + "\t");
            }
        }

        private static void SolicitarNumeros(ref int minimo, ref int maximo)
        {
            Console.WriteLine("Hola, vamos a generar 20 numeros aleatorios en base a 2 numeros (minimo y maximo).");
            string solicitarMin = "Introduce el valor mínimo: ";
            string solicitarMax = "Introduce el valor máximo: ";
            minimo = ValidarNumero(solicitarMin, false);
            maximo = ValidarNumero(solicitarMax, true, minimo);
        }

        private static int ValidarNumero(string mensaje, bool checkMax, in int max = 0)
        {
            int result = 0;
            bool resultadoValido = false;
            do
            {
                Console.Write(mensaje);
                if (!int.TryParse(Console.ReadLine(), out result))
                {
                    Console.WriteLine("ERROR: Dato introducido no valido");
                    continue;
                }
                if (result <= max)
                {
                    Console.WriteLine("ERROR: el valor minimo es mayor o igual que el valor maximo");
                    continue;
                }
                resultadoValido = true;
            }
            while (!resultadoValido);
            return result;
        }

        private static void GenerarNumerosAleatorios(int[] vectorNumeros, in int minimo, in int maximo)
        {
            Random random = new Random();
            for (int i = 0; i < vectorNumeros.Length; i++)
            {
                int valorAleatorio = random.Next(minimo, maximo + 1);
                vectorNumeros[i] = valorAleatorio;
            }
        }
    }
}
