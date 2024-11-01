using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace matriz_random_2_x_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Realiza un programa que rellene aleatoriamente una matriz de 2x3(2 filas 3 columnas).
            // El programa debe mostrarla en forma de tabla después de que se haya rellenado.
            // A tener en cuenta:
            // • Los números deben ser de tipo int
            // • Tendrás que utilizar la clase Random
            // Declaración:
            // Random aleatorio = new Random();
            // Asignación:
            // int num1 = aleatorio.Next(100);
            // Console.WriteLine(aleatorio.Next(10, 20));
            // FUNCIONALIDAD EXTRA: Muestra junto a cada fila y columna el resultado de la suma de todos los números que la componen

            // Crear matriz
            int[,] matrizRandom = new int[2, 3];
            Random aleatorio = new Random();

            // Rellenar datos aleatorios iterando
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    matrizRandom[i, j] = aleatorio.Next(1, 20);
                }
            }

            // Creamos variables para almacenar las sumas
            int sumaColumna1 = 0;
            int sumaColumna2 = 0;
            int sumaColumna3 = 0;
            int sumaColumnaTotal = 0;

            // Recorremos la matriz y vamos obteniendo los resultados de las sumas e imprimiendo la tabla
            for (int i = 0; i < 2; i++)
            {
                sumaColumna1 += matrizRandom[i, 0];
                sumaColumna2 += matrizRandom[i, 1];
                sumaColumna3 += matrizRandom[i, 2];

                int sumaFila = 0;
                for (int j = 0; j < 3; j++)
                {
                    Console.Write($"{matrizRandom[i, j]} \t");
                    sumaFila += matrizRandom[i, j];
                }
                Console.WriteLine($" |\t{sumaFila}");
                sumaColumnaTotal += sumaFila;
            }
            Console.WriteLine("___________________________________");
            Console.WriteLine($"{sumaColumna1}\t{sumaColumna2}\t{sumaColumna3}\t |\t{sumaColumnaTotal}");
        }
    }
}
