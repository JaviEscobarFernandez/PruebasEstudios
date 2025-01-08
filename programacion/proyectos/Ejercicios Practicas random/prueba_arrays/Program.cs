using System;

namespace prueba_arrays
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Declarar vector sin inicializarlo
            int[] vector1 = new int[5];
            for (int i = 0; i < vector1.Length; i++)
            {
                // Al recorrer el vector sin inicializar el valor por defecto es 0;
                Console.WriteLine($"posicion {i}: {vector1[i]}");
                // Le asignamos valor a cada 1
                vector1[i] = i + 1;
            }
            // recorremos el vector ahora con un foreach
            int count = 0;
            Console.WriteLine("Vector ya inicializado");
            foreach (int v in vector1)
            {
                Console.WriteLine($"posicion {count}: {v}");
                count++;
            }
            // Diferentes formas de declarar arrays ya con valores establecidos
            int[] vector2 = new int[] { 1, 2, 3, 4, 5 };
            int[] vecotr3 = { 1, 2, 3, 4, 5 };
            for (int i = 0; i < vector1.Length; i++)
            {
                // Todos tienen los mismos valores en las mismas posiciones, son iguales
                if (vector1[i] == vector2[i] && vector2[i] == vecotr3[i])
                    Console.WriteLine($"vector 1, vector2 y vector3 tienen el mismo valor en la posicion {i}, que es: {vector1[i]}");
            }

            // Probando ahora matrices (arrays bidimensionales)
            int[,] matriz = new int[2, 4];
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {
                    // Por defecto son 0
                    Console.WriteLine($"El valor de matriz[{i}, {j}] antes de asignarle valor es: {matriz[i, j]}");
                    matriz[i, j] = i + j + 1;
                    // aqui le establecemos otro valor
                    Console.WriteLine($"El valor de matriz[{i}, {j}] despues de asignarle valor es: {matriz[i, j]}");
                }
            }

            // Esto es para probar que los tipos de datos char se pueden convertir implicitamente a int, ya que son caracteres ASCII
            int[,] multiDimensionalArray2 = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
            for (int i = 0; i < multiDimensionalArray2.GetLength(0); i++)
            {
                for (int j = 0; j < multiDimensionalArray2.GetLength(1); j++)
                {
                    Console.WriteLine($"El valor de multiDimensionalArray2[{i}, {j}] es: {multiDimensionalArray2[i, j]} que es el caracter: {Convert.ToChar(multiDimensionalArray2[i, j])}");
                    // mostraria datos como: "El valor de multiDimensionalArray2[0, 0] es: 97 que es el caracter: a" ... etc
                }
            }
        }
    }
}
